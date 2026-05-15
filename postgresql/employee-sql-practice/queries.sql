
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
    WHERE NOT is_active;

-- 08.
    SELECT employees.first_name, employees.last_name, departments.name,departments.location
    FROM employees
    FULL JOIN departments
    ON departments.id = employees.department_id;

-- 09.
    SELECT  e.first_name || ' ' || e.last_name AS employee_name,
            m.first_name || ' ' || m.last_name AS manager_name
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
    SELECT
    p.name AS project_name,
    COUNT(ep.employee_id) AS employee_count
    FROM projects p
        LEFT JOIN employee_projects ep
    ON p.id = ep.project_id
    GROUP BY p.id, p.name;

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
    WHERE ep.employee_id IS NULL;

-- 30.
    SELECT p.name AS project_name, COUNT(ep.employee_id) AS employee_count
    FROM projects p
        LEFT JOIN public.employee_projects ep on p.id = ep.project_id
    GROUP BY p.name
    ORDER BY count(ep.employee_id) DESC
    LIMIT 1;

-- 31.
    SELECT e.first_name || ' ' || e.last_name AS employee_name, SUM(ep.hours_per_week) AS hours_per_week
    FROM employee_projects ep
        LEFT JOIN public.employees e on ep.employee_id = e.id
    GROUP BY e.first_name, e.last_name
    ORDER BY SUM(ep.hours_per_week) DESC
    LIMIT 5;

-- 32.
    SELECT DISTINCT
        e.first_name || ' ' || e.last_name AS employee_name,
        d.name AS department_name
    FROM employees e
        JOIN public.projects p on e.department_id = p.department_id
        JOIN public.departments d on e.department_id = d.id
    WHERE p.status = 'active';

-- 33.
    SELECT d.name AS department_name ,d.annual_budget AS department_annual_budget, COALESCE(SUM(e.salary), 0) AS total_employee_salary
    FROM departments d
        LEFT JOIN public.employees e on d.id = e.department_id
    GROUP BY d.id, d.annual_budget, d.name;

-- 34.
    SELECT d.name AS department_name,
           d.annual_budget,
           COALESCE(SUM(e.salary), 0) AS total_salary
    FROM departments d
        LEFT JOIN public.employees e on d.id = e.department_id
    GROUP BY d.name,d.id, d.annual_budget
    HAVING d.annual_budget > COALESCE(SUM(e.salary), 0);

-- 35.
    SELECT
        p.name AS project_name,
        COALESCE(AVG(e.salary),0) AS avg_salary_of_active_prjects
    FROM projects p
        LEFT JOIN employees e
        ON e.department_id = p.department_id
    WHERE p.status = 'active'
    GROUP BY p.name, p.id;

-- 36. Çalışanları maaş aralığına göre sınıflandır.
    SELECT
        e.first_name|| ' ' || e.last_name AS employee_name,
        e.salary,
        CASE
            WHEN 0 <= e.salary AND e.salary<50000 THEN '0-50000'
            WHEN 50000 <= e.salary AND e.salary<100000 THEN '50000-100000'
            WHEN 100000 <= e.salary AND e.salary<150000 THEN '100000-150000'
            WHEN 150000 <= e.salary AND e.salary<200000 THEN '150000-200000'
            ELSE '200000+'
        END AS salary_range
    FROM employees e;

-- 37.
    SELECT d.name AS department_name, count(e.id) AS employee_count
    FROM departments d
        LEFT JOIN employees e
        ON e.department_id = d.id
    GROUP BY d.id,d.name;

-- 38. Maaşı kendi departman ortalamasından yüksek olan çalışanları listele.
    SELECT employee_name,
           salary,
           department_name,
           avg_salary_of_department
    FROM(
        SELECT
            e.first_name || ' ' || e.last_name AS employee_name,
            e.salary,
            d.name AS department_name,
            AVG(e.salary) OVER(PARTITION BY e.department_id) AS avg_salary_of_department
        FROM employees e
            LEFT JOIN public.departments d on e.department_id = d.id
        )
    WHERE salary > avg_salary_of_department;


-- 39.
    SELECT p.name AS project_name, p.start_date
    FROM projects p
    WHERE EXTRACT(YEAR FROM start_date) = 2024;

-- 40. Manager'ı olmayan çalışanları yani üst yöneticileri listele.
    SELECT e.first_name|| ' ' || e.last_name AS employee_name
    FROM employees e
    WHERE e.manager_id IS NULL;
