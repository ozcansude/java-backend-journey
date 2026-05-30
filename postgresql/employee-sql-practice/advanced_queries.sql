-- 1. Her departmanda çalışanları maaşa göre sırala.
SELECT
    id,
    first_name,
    department_id,
    salary,
    ROW_NUMBER() OVER (
        PARTITION BY department_id
        ORDER BY salary DESC
    ) AS departman_sirasi
FROM employees;

-- Her departmandan sadece maaşı en yüksek olan çalışanı getir. row_number ve cte ile
WITH ranked_employees AS(
    SELECT
    e.id,
    e.first_name|| ' '|| e.last_name AS employee_name,
    d.name AS department_name,
    e.title,
    e.salary,
    row_number() over (
        PARTITION BY d.id
        ORDER BY e.salary DESC
        )AS rn
    FROM employees e
        RIGHT JOIN departments d ON e.department_id = d.id
    )
SELECT
    department_name,
    employee_name,
    title,
    salary
FROM ranked_employees
WHERE rn = 1;

--4. Maaşı şirket ortalamasından yüksek olan çalışanları listele. - subquery ile
SELECT  first_name || ' ' || last_name AS employee_name,
        salary
FROM employees
WHERE salary > (
    SELECT AVG(salary)
    FROM employees )
GROUP BY first_name || ' ' || last_name, salary;

--5. En yüksek maaşa sahip çalışanı subquery ile bul.
SELECT
    e.first_name ||' ' || last_name AS employee_name,
    salary
FROM employees e
WHERE e.salary = (
    SELECT MAX(e2.salary)
    FROM employees e2
    );

-- 6.Engineering departmanının ortalama maaşından yüksek maaş alan çalışanları listele.
SELECT
    e.first_name ||' ' || last_name AS employee_name,
    salary
FROM employees e
    JOIN public.departments d on e.department_id = d.id
WHERE d.name = 'Engineering'
    AND e.salary > (
    SELECT AVG(e2.salary) AS avg_salary
    FROM employees e2
        JOIN public.departments d2 on d2.id = e2.department_id
    WHERE d2.name = 'Engineering'
    );

-- 7.Maaşı kendi departman ortalamasından yüksek olan çalışanları correlated subquery ile bul.⭐️
SELECT
    e.first_name ||' ' || last_name AS employee_name,
    d.name,
    salary
FROM employees e
    JOIN public.departments d on e.department_id = d.id
WHERE e.salary > (
    SELECT AVG(e2.salary) AS employee_salary
    FROM employees e2
    WHERE e2.department_id = e.department_id
    );

-- 8.Kendi manager’ından daha yüksek maaş alan çalışanları bul.
SELECT
    e.first_name ||' ' || e.last_name AS employee_name,
    e.salary AS employee_salary
FROM employees e
WHERE e.manager_id IS NOT NULL
    AND e.salary > (
    SELECT m.salary
    FROM employees m
    WHERE m.id = e.manager_id
    );

-- 9.Hiçbir projeye atanmamış çalışanları NOT EXISTS ile bul.
SELECT
    e.first_name ||' ' || e.last_name AS employee_name
FROM employees e
WHERE NOT EXISTS(
    SELECT 1
    FROM employee_projects ep
    WHERE ep.employee_id = e.id
);
-- 10.En az bir projede çalışan aktif çalışanları bul.
SELECT
    e.first_name ||' ' || e.last_name AS employee_name
FROM employees e
WHERE e.is_active = 'true' AND EXISTS(
    SELECT 1
    FROM employee_projects ep
    WHERE ep.employee_id = e.id
);

-- 11.Hiç aktif projesi olmayan departmanları bul.
SELECT d.name AS department_name
FROM departments d
WHERE NOT EXISTS(
    SELECT 1
    FROM projects p2
    WHERE p2.department_id = d.id
      AND p2.status = 'active'
);

-- 12.Her çalışanın toplam proje saatini CTE ile hesapla.
WITH employee_total_hours AS(
    SELECT ep.employee_id,
           SUM(ep.hours_per_week) AS total_hours
    FROM employee_projects ep
    GROUP BY ep.employee_id
)
SELECT
    e.first_name ||' ' || e.last_name AS employee_name,
    COALESCE(total_hours, 0)
FROM employee_total_hours eth
    RIGHT JOIN employees e ON e.id = eth.employee_id;

-- 13.Departman bazında maaş toplamı ve bütçe farkını CTE ile hesapla. Aştığı durumda budget_status'te over budget yazsın.
WITH department_salary AS(
    SELECT
        d.name AS department_name,
        d.id AS department_id,
        d.annual_budget,
        COALESCE(SUM(e.salary),0) AS total_salary
    FROM departments d
    LEFT JOIN public.employees e on d.id = e.department_id
    GROUP BY d.name, d.id, d.annual_budget
)
SELECT
    department_id,
    department_name,
    annual_budget - total_salary AS budget_difference,
    CASE
        WHEN annual_budget >= total_salary THEN 'budget ok'
        ELSE 'over budget'
    END AS budget_status
FROM department_salary;

-- 14.Her çalışanın yanında kendi departmanının ortalama maaşını göster.
SELECT
    e.first_name ||' ' || e.last_name AS employee_name,
    d.name AS department_name,
    e.salary,
    ROUND (AVG(e.salary) OVER (PARTITION BY e.department_id),2) AS department_avg_salary
FROM employees e
    LEFT JOIN departments d on e.department_id = d.id;

-- 15.Her çalışanın maaşı ile departman ortalaması arasındaki farkı göster.
SELECT
    e.first_name ||' ' || e.last_name AS employee_name,
    d.name AS department_name,
    e.salary,
    ROUND(AVG(e.salary) OVER (PARTITION BY e.department_id), 2) AS department_avg_salary,
    e.salary - ROUND(AVG(e.salary) OVER (PARTITION BY d.id),2) AS salary_difference
FROM employees e
    LEFT JOIN departments d on e.department_id = d.id;

-- 16.Şirket genelinde çalışanları maaşa göre sırala. Aynı maaşı alan çalışanlar aynı numarayı alsın.
SELECT
    e.first_name ||' ' || e.last_name AS employee_name,
    e.salary,
    RANK() OVER(ORDER BY e.salary DESC) AS salary_rank
FROM employees e
ORDER BY salary_rank;

--17. Çalışanları maaş seviyesine göre sınıflandır.
SELECT
    e.first_name ||' ' || e.last_name AS employee_name,
    e.salary,
    CASE
        WHEN salary< 50000 THEN 'low'
        WHEN salary>=50000 AND salary < 100000 THEN 'mid'
        ELSE 'high'
    END AS salary_level
FROM employees e
ORDER BY salary DESC;

-- 18.Performans skorunu yazılı etikete çevir.
SELECT
    e.first_name ||' ' || e.last_name AS employee_name,
    e.performance_score,
    CASE
        WHEN e.performance_score = 5 THEN 'excellent'
        WHEN e.performance_score = 4 THEN 'okay'
        WHEN e.performance_score = 3 THEN 'average'
        WHEN e.performance_score = 2 THEN 'needs improvement'
        WHEN e.performance_score = 5 THEN 'POOR!'
    END AS performances
FROM employees e;

-- 1 9.Proje durumlarını kullanıcı dostu hale getir.(projects'teki yabancı kelimeleri türkçe'ye çevir)
SELECT
    name AS project_name,
    status,
    CASE
        WHEN status = 'active' THEN 'Devam ediyor'
        WHEN status = 'completed' THEN 'Tamamlandı'
        WHEN status = 'paused' THEN 'Beklemede'
        WHEN status = 'cancelled' THEN 'İptal edildi'
    END AS status_label
FROM projects;

-- 20.Manager’ı olmayan çalışanlara “Top Manager” yaz.
SELECT
    e.first_name || ' ' || e.last_name AS employee_name,
    COALESCE(m.first_name || ' ' || m.last_name, 'Top Manager') AS manager_name
FROM employees e
    LEFT JOIN employees m on e.manager_id = m.id;
--WHERE e.manager_id IS NULL; -- eğer sadece top managerlerı görmek istersem bu filtrelemeyi de yaparım

-- 21.Projesi olmayan çalışanlarda toplam saati 0 göster.
SELECT
    e.first_name || ' ' || e.last_name AS employee_name,
    COALESCE(SUM(ep.hours_per_week),0) AS total_hours_per_week
FROM employees e
LEFT JOIN public.employee_projects ep on e.id = ep.employee_id
GROUP BY e.id, e.first_name, e.last_name
ORDER BY total_hours_per_week DESC ;

-- 22.Her çalışanın şirkette kaç yıldır çalıştığını göster.
SELECT
    e.first_name || ' ' || e.last_name AS employee_name,
    e.hire_date,
    EXTRACT( YEAR FROM AGE(CURRENT_DATE, e.hire_date)) AS working_for_years
FROM employees e
ORDER BY working_for_years DESC;

-- 23.Son 2 yılda işe başlayan çalışanları listele.
SELECT
    e.first_name || ' ' || e.last_name AS employee_name,
    e.hire_date,
    EXTRACT(YEAR FROM AGE(CURRENT_DATE, e.hire_date)) AS working_for_years
FROM employees e
WHERE EXTRACT(YEAR FROM AGE(CURRENT_DATE, e.hire_date))<= 2
ORDER BY working_for_years;

-- 24.Projelerin kaç gündür sürdüğünü hesapla.
SELECT
    p.name,
    p.start_date,
    p.end_date,
    COALESCE(p.end_date, current_date) - start_date AS project_duration_days
FROM projects p
ORDER BY project_duration_days;








