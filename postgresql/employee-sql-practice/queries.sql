
-- 01.
SELECT * FROM employees;

-- 02.
SELECT *
FROM employees
WHERE is_active;

-- 03.
    SELECT *
    FROM employees
    WHERE salary>70000
    ORDER BY salary;

-- 04.
    SELECT *
    FROM employees
    ORDER BY hire_date DESC
    LIMIT 5;

-- 05.
    SELECT *
    FROM employees
    WHERE hire_date > '2022-01-01';

-- 06.
    SELECT *
    FROM employees
    WHERE performance_score = 5;

-- 07.
    SELECT *
    FROM employees
    WHERE !is_active;

-- 08.
    SELECT employees.first_name, employees.last_name, departments.name,departments.location
    FROM employees
    FULL JOIN departments
    ON departments.id = employees.department_id

-- 09. (⭐️tekrar bak)
    SELECT e.first_name, e.last_name,
           m.first_name AS manager_first_name
    FROM employees e
    LEFT JOIN employees m
        ON e.manager_id = m.id;

-- 10.
    SELECT projects.name,departments.name,projects.status
    FROM projects
    LEFT JOIN departments
        ON projects.department_id = departments.id;

-- 11.
    SELECT p.name, e.first_name, ep.role, ep.hours_per_week
    FROM employee_projects ep
        LEFT JOIN projects p
        ON ep.project_id = p.id
        LEFT JOIN employees e
        ON ep.employee_id = e.id;

-- 12.
    SELECT e.first_name, d.name
    FROM employees e
        RIGHT JOIN departments d
        ON e.department_id = d.id
    WHERE d.name = 'Engineering';

-- 13.
    SELECT *
    FROM employees e
        LEFT JOIN departments d
        ON e.department_id = d.id
    WHERE d.location = 'Istanbul';

-- 14.
    SELECT count(*) AS total_employees
    FROM employees;

-- 15.
    SELECT
     count(*) FILTER ( WHERE is_active = true)  AS active_count,
     COUNT(*) FILTER( WHERE is_active = false) AS inactive_count
     FROM employees ;

-- 16.
    SELECT
        d.name AS department_name,
        count(e.id) AS employee_count
    FROM departments d
        LEFT JOIN public.employees e on d.id = e.department_id
        GROUP BY d.name,d.id;

-- 17.
    SELECT
        d.name AS department_name,
        ROUND(AVG(e.salary),2) AS average_salary_of_departments
    FROM departments d
        LEFT JOIN public.employees e on d.id = e.department_id
        GROUP BY d.name;

-- 18.
    SELECT d.name, MAX(e.salary) AS max_salary, MIN(e.salary) AS min_salary
    FROM departments d
        JOIN public.employees e on d.id = e.department_id
    GROUP BY d.name;


-- 19.
    SELECT SUM(e.salary) AS total_salary_of_company
    FROM employees e;

-- 20.
    SELECT p.name, SUM(ep.hours_per_week) AS total_weekly_hours
    FROM employee_projects ep
        RIGHT JOIN projects p
        ON p.id = ep.project_id
    GROUP BY p.name, p.id;

-- 21.
    SELECT p.name, count(e.id)
    FROM employee_projects ep
        LEFT JOIN employees e
        ON  e.id = ep.employee_id
        LEFT JOIN public.projects p on ep.project_id = p.id
    GROUP BY p.name;

-- 22.
    SELECT d.name,
           ROUND(AVG(e.salary),2) AS avg_department_salary
    FROM departments d
        LEFT JOIN public.employees e on d.id = e.department_id
    GROUP BY d.name
    HAVING AVG(e.salary) > 70000;

-- 23.
    SELECT d.name AS department_name, count(e.department_id) AS count_employees
    FROM departments d
        LEFT JOIN public.employees e on d.id = e.department_id
    GROUP BY d.name
    HAVING count(e.department_id) > 5;

-- 24.
    SELECT p.name AS project_name, SUM(ep.hours_per_week) AS sum_of_weekly_hours
    FROM projects p
        LEFT JOIN public.employee_projects ep on p.id = ep.project_id
    GROUP BY p.name
    HAVING SUM(ep.hours_per_week) > 40;

-- 25.
    SELECT e.first_name, count(e.id) AS working_on
    FROM employee_projects ep
        JOIN employees e ON e.id = ep.employee_id
    group by e.first_name
    HAVING count(e.id) > 1;

-- 26.⭐️TEKAR BAK
    SELECT
        m.first_name || ' ' || m.last_name AS manager_name,
        count(e.id) AS manage_count
    FROM employees m
        JOIN employees e ON m.id = e.manager_id
    GROUP BY m.first_name, m.last_name,m.id
    HAVING count(e.id) >= 3;

-- 27. Toplam proje bütçesi 100.000'den fazla olan departmanları listele.
    SELECT d.name AS department_name, SUM(p.budget) AS total_departmen_budget
    FROM departments d
        LEFT JOIN public.projects p on d.id = p.department_id
    GROUP BY d.id, d.name
    HAVING SUM(p.budget) > 100000;

-- 28
    SELECT e.first_name || ' ' || e.last_name AS employee_name, SUM(ep.hours_per_week)
    FROM employees e
        LEFT JOIN employee_projects ep ON e.id = ep.employee_id
    GROUP BY e.first_name || ' ' || e.last_name;

-- 29. Hiçbir projeye atanmamış çalışanları bul.
    SELECT e.first_name || ' ' || e.last_name AS employee_name
    FROM employees e
        LEFT JOIN employee_projects ep ON e.id = ep.employee_id
    GROUP BY e.first_name || ' ' || e.last_name, ep.employee_id
    HAVING ep.employee_id IS NULL;
