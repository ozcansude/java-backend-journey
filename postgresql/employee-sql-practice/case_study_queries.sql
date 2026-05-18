--A
 WITH department_health_report AS(
     SELECT
        d.name AS department_name,
        d.location,
        COUNT(e.id) AS count_employee,
        COALESCE(SUM(CASE WHEN e.is_active = true THEN 1 ELSE 0 END),0) AS active_employee_count,
        COALESCE(SUM(CASE WHEN e.is_active = false THEN 1 ELSE 0 END),0) AS passive_employee_count,
        COALESCE(AVG(e.salary),0) AS avg_salary,
        COALESCE(SUM(e.salary),0) AS total_salary,
        COALESCE(d.annual_budget,0) AS annual_budget,
        CASE
            WHEN d.annual_budget >= SUM(e.salary) THEN 'budget_ok'
            ELSE 'over_budget'
        END AS budget_status
     FROM departments d
        LEFT JOIN public.employees e on d.id = e.department_id
     GROUP BY d.name, d.location, d.id,d.annual_budget
 )
 SELECT
     department_name,
     location,
     count_employee,
     active_employee_count,
     passive_employee_count,
     avg_salary,
     total_salary,
     annual_budget,
     budget_status
 FROM department_health_report;

--B
SELECT
     p.name AS project_name,
     p.status AS project_status,
     d.name AS department_name,
     coalesce(count(ep.employee_id),0) AS count_employee,
     SUM(ep.hours_per_week) AS total_weekly_hours,
     COALESCE(round(AVG(ep.hours_per_week)::numeric,2),0) AS avg_weekly_hours,
     CASE
         WHEN LOWER(p.status) = 'active' THEN 'yes'
         ELSE 'no'
     END AS is_active,
     CASE
        WHEN COALESCE(SUM(ep.hours_per_week),0) < 20 THEN 'low'
        WHEN COALESCE(SUM(ep.hours_per_week),0) >= 20 AND COALESCE(SUM(ep.hours_per_week),0) < 40 THEN 'medium'
        ELSE 'high'
     END AS workload_level
FROM projects p
    left join public.departments d on p.department_id = d.id
    left join public.employee_projects ep on p.id = ep.project_id
group by d.name,d.name, p.status, p.name, d.id;



--C
SELECT
    e.first_name|| ' ' || e.last_name AS employee_name,
    d.name AS department_name,
    e.salary AS employee_salary,
    RANK() OVER(
        PARTITION BY department_id
        order by e.salary DESC
        ) as department_order,
    RANK() OVER(
        ORDER BY e.salary DESC
        ) as company_salary_rank
FROM departments d
    LEFT JOIN public.employees e on d.id = e.department_id
GROUP BY e.first_name, e.last_name, d.name, e.salary,e.department_id;

--D
SELECT
    m.first_name|| ' '|| m.last_name AS manager_name,
    count(DISTINCT e.id) AS count_managed_employee,
    AVG(e.salary) AS avg_managed_employee_salary,
    COALESCE(SUM(ep.hours_per_week),0) AS total_managed_employee_project_hours,
    m.salary AS manager_salary,
    CASE
        WHEN COALESCE(COUNT(DISTINCT e.id),0) >= 5 THEN 'senior_manager'
        WHEN COUNT(DISTINCT e.id) BETWEEN 3 AND 4 THEN 'manager'
        WHEN COALESCE(COUNT(DISTINCT e.id),0) >= 1 AND COALESCE(COUNT(e.id),0) < 3 THEN 'team_lead'
    END AS manager_level
FROM employees e
    JOIN employees m on m.id = e.manager_id
    LEFT JOIN public.employee_projects ep on e.id = ep.employee_id
GROUP BY m.first_name, m.last_name, m.salary,m.id;

--E
SELECT
     e.first_name|| ' ' || e.last_name AS employee_name,
     CASE
         WHEN COALESCE(SUM(ep.hours_per_week),0) > 30 THEN 'overloaded'
         WHEN COALESCE(SUM(ep.hours_per_week),0)  BETWEEN 16 AND 30 THEN 'normal'
         WHEN COALESCE(SUM(ep.hours_per_week),0)  BETWEEN 1 AND 15 THEN 'underloaded'
         ELSE 'not_assigned'
     END AS employee_classify
FROM employees e
    LEFT JOIN public.employee_projects ep on e.id = ep.employee_id
GROUP BY e.first_name, e.last_name;

--F
WITH employee_salary_stats AS(
    SELECT
        e.id,
        e.first_name|| ' ' || e.last_name AS employee_name,
        d.name AS department_name,
        e.salary AS salary,
        AVG(e.salary) OVER(
            PARTITION BY e.department_id
            ) AS department_avg_salary,
        RANK() OVER(
            PARTITION BY e.department_id
            ORDER BY e.salary DESC
            ) AS rank_in_department
    FROM employees e
        LEFT JOIN public.departments d on e.department_id = d.id
)
SELECT
    employee_name,
    department_name,
    salary,
    department_avg_salary,
    rank_in_department,
    salary - department_avg_salary AS salary_difference

FROM employee_salary_stats
WHERE salary > department_avg_salary;

--G
SELECT
     p.name AS project_name,
     e.first_name|| ' ' || e.last_name AS employee_name,
     ed.name AS employee_department,
     pd.name AS project_department,
     ep.role,
     ep.hours_per_week,
     e.salary,
     e.performance_score

FROM employee_projects ep
    LEFT JOIN public.employees e on e.id = ep.employee_id
    LEFT JOIN public.projects p on p.id = ep.project_id
    LEFT JOIN public.departments ed on ed.id = e.department_id
    LEFT JOIN public.departments pd on p.department_id = pd.id
WHERE p.status = 'active';

--H
SELECT
    e.first_name || ' ' || e.last_name AS employee_name
FROM employees e
WHERE e.is_active = true
    AND NOT EXISTS(
        SELECT 1
        FROM employee_projects ep2
            LEFT JOIN public.projects p2 on ep2.project_id = p2.id
        WHERE ep2.employee_id = e.id
            AND p2.status= 'active');

--I
WITH employee_tenure AS (
    SELECT
        e.first_name|| ' ' || e.last_name AS employee_name,
        e.hire_date,
        extract(YEAR FROM AGE(CURRENT_DATE,hire_date) )AS years_worked
    FROM employees e
    )
SELECT
    employee_name,
    hire_date,
    years_worked,
    CASE
        WHEN years_worked >= 5 THEN 'veteran'
        WHEN years_worked BETWEEN 2 AND 4 THEN 'experienced'
        ELSE 'new'
    END AS employee_level_by_tenure
FROM employee_tenure;


--DROP VIEW IF EXISTS employee_workload_report;
--DROP VIEW IF EXISTS department_health_report;


--J
CREATE OR REPLACE VIEW department_health_report AS(
SELECT
    d.id,
    d.name,
    d.annual_budget,
    COALESCE(SUM(e.salary),0) AS total_salary_costs,
    CASE
        WHEN COALESCE(SUM(e.salary),0) > d.annual_budget THEN 'over_budget'
        ELSE 'budget_ok'
    END AS budget_status
FROM departments d
    LEFT JOIN public.employees e on d.id = e.department_id
GROUP BY d.id
);

CREATE OR REPLACE VIEW employee_workload_report AS(
SELECT
    e.first_name || ' '||e.last_name AS employee_name,
    e.title,
    e.performance_score,
    d.name AS department_name,
    COALESCE(SUM(ep.hours_per_week), 0) AS total_hours_per_week,
    CASE
        WHEN COALESCE(SUM(ep.hours_per_week), 0) = 0 THEN 'not_assigned'
        WHEN COALESCE(SUM(ep.hours_per_week), 0) < 15 THEN 'underloaded'
        WHEN COALESCE(SUM(ep.hours_per_week), 0) BETWEEN 15 AND 30 THEN 'normal'
        ELSE 'overloaded'
    END AS workload_status


FROM employees e
    LEFT JOIN public.employee_projects ep on e.id = ep.employee_id
    LEFT JOIN public.departments d on d.id = e.department_id
GROUP BY d.id, e.id

);

SELECT *
FROM department_health_report dhr
WHERE dhr.budget_status = 'over_budget';

SELECT *
FROM employee_workload_report
WHERE workload_status = 'overloaded';
