INSERT INTO departments (id, name, location, annual_budget) VALUES
(1, 'Engineering', 'Istanbul', 600000.00),
(2, 'Sales', 'Ankara', 350000.00),
(3, 'Human Resources', 'Izmir', 150000.00),
(4, 'Finance', 'Istanbul', 280000.00),
(5, 'Marketing', 'Bursa', 220000.00),
(6, 'Support', 'Remote', 180000.00);

INSERT INTO employees
(id, first_name, last_name, department_id, title, hire_date, salary, performance_score, manager_id, is_active)
VALUES
(1, 'Ayla', 'Demir', 1, 'Engineering Manager', '2018-02-12', 120000.00, 5, NULL, true),
(2, 'Mehmet', 'Kaya', 2, 'Sales Director', '2019-04-03', 95000.00, 4, NULL, true),
(3, 'Selin', 'Arslan', 3, 'HR Manager', '2020-01-20', 78000.00, 4, NULL, true),
(4, 'Burak', 'Celik', 4, 'Finance Manager', '2017-11-01', 92000.00, 5, NULL, true),
(5, 'Ece', 'Yilmaz', 5, 'Marketing Manager', '2021-06-14', 83000.00, 4, NULL, true),
(6, 'Can', 'Oz', 6, 'Support Lead', '2020-08-25', 70000.00, 4, NULL, true),
(7, 'Sude', 'Özcan', 1, 'Backend Developer', '2021-03-15', 74000.00, 4, 1, true),
(8, 'Berke', 'Dinler', 1, 'Frontend Developer', '2022-05-10', 72000.00, 3, 1, true),
(9, 'Zeynep', 'Koc', 1, 'Data Analyst', '2021-09-22', 72000.00, 5, 1, true),
(10, 'Ozan', 'Aksoy', 1, 'DevOps Engineer', '2023-01-09', 76000.00, 4, 1, true),
(11, 'Irem', 'Polat', 1, 'QA Engineer', '2022-11-17', 62000.00, 3, 1, true),
(12, 'Kerem', 'Gunes', 1, 'Junior Developer', '2024-03-04', 48000.00, 3, 7, true),
(13, 'Asli', 'Korkmaz', 2, 'Sales Representative', '2021-02-18', 55000.00, 3, 2, true),
(14, 'Emre', 'Yildiz', 2, 'Account Executive', '2020-10-06', 63000.00, 4, 2, true),
(15, 'Burcu', 'Tas', 2, 'Customer Success Specialist', '2022-07-12', 58000.00, 4, 2, true),
(16, 'Ali', 'Cetin', 2, 'Sales Representative', '2023-09-05', 51000.00, 2, 2, false),
(17, 'Naz', 'Er', 3, 'HR Specialist', '2021-12-01', 52000.00, 4, 3, true),
(18, 'Cem', 'Ucar', 3, 'Recruiter', '2023-04-19', 50000.00, 3, 3, true),
(19, 'Elif', 'Soy', 3, 'HR Assistant', '2024-01-11', 42000.00, 3, 3, true),
(20, 'Hakan', 'Kurt', 4, 'Accountant', '2020-03-23', 60000.00, 4, 4, true),
(21, 'Derya', 'Aksu', 4, 'Financial Analyst', '2021-07-28', 68000.00, 5, 4, true),
(22, 'Tolga', 'Er', 4, 'Budget Specialist', '2022-02-14', 65000.00, 3, 4, false),
(23, 'Lara', 'Deniz', 5, 'Social Media Specialist', '2022-08-08', 54000.00, 4, 5, true),
(24, 'Kaan', 'Bora', 5, 'Content Strategist', '2021-05-27', 58000.00, 3, 5, true),
(25, 'Melis', 'Kaplan', 5, 'SEO Specialist', '2023-10-02', 56000.00, 4, 5, true),
(26, 'Suna', 'Bilge', 6, 'Support Specialist', '2021-01-29', 45000.00, 4, 6, true),
(27, 'Alp', 'Toker', 6, 'Support Specialist', '2022-06-16', 46000.00, 3, 6, true),
(28, 'Mine', 'Sezer', 6, 'Technical Support Specialist', '2023-02-21', 50000.00, 5, 6, true),
(29, 'Baran', 'Ekin', 6, 'Support Intern', '2024-04-15', 36000.00, 3, 6, true),
(30, 'Yasemin', 'Tunc', 1, 'Product Analyst', '2022-12-05', 70000.00, 4, 9, true);

INSERT INTO projects
(id, name, department_id, start_date, end_date, budget, status)
VALUES
(1, 'Payroll Automation', 4, '2023-01-15', '2023-09-30', 85000.00, 'completed'),
(2, 'Mobile App Redesign', 1, '2024-02-01', NULL, 150000.00, 'active'),
(3, 'CRM Migration', 2, '2023-06-01', '2024-03-31', 120000.00, 'completed'),
(4, 'Hiring Pipeline', 3, '2024-01-10', NULL, 40000.00, 'active'),
(5, 'Brand Awareness Campaign', 5, '2024-04-01', NULL, 75000.00, 'active'),
(6, 'Customer Portal', 6, '2024-02-15', NULL, 95000.00, 'active'),
(7, 'Data Warehouse', 1, '2023-10-01', NULL, 180000.00, 'active'),
(8, 'Office Cost Review', 4, '2024-03-01', '2024-06-15', 30000.00, 'paused'),
(9, 'Retention Program', 2, '2024-05-01', NULL, 60000.00, 'active'),
(10, 'Security Audit', 1, '2023-07-01', '2023-12-15', 50000.00, 'completed');

INSERT INTO employee_projects
(employee_id, project_id, role, hours_per_week, assigned_at)
VALUES
(7, 2, 'Backend Developer', 20, '2024-02-01'),
(8, 2, 'Frontend Developer', 18, '2024-02-01'),
(11, 2, 'QA Engineer', 10, '2024-02-05'),
(30, 2, 'Product Analyst', 8, '2024-02-01'),
(9, 7, 'Data Modeler', 20, '2023-10-01'),
(10, 7, 'Infrastructure Owner', 15, '2023-10-01'),
(7, 7, 'API Developer', 8, '2023-10-10'),
(30, 7, 'Reporting Analyst', 12, '2023-10-12'),
(20, 1, 'Accounting Process Owner', 12, '2023-01-15'),
(21, 1, 'Financial Analyst', 10, '2023-01-20'),
(22, 1, 'Budget Specialist', 8, '2023-01-20'),
(10, 1, 'Automation Engineer', 8, '2023-02-01'),
(13, 3, 'Sales Operations', 10, '2023-06-01'),
(14, 3, 'Account Data Owner', 14, '2023-06-01'),
(15, 3, 'Customer Data Owner', 12, '2023-06-10'),
(9, 3, 'Data Mapping Support', 6, '2023-06-15'),
(17, 4, 'HR Workflow Owner', 12, '2024-01-10'),
(18, 4, 'Recruitment Flow Owner', 10, '2024-01-12'),
(19, 4, 'Documentation Assistant', 6, '2024-01-20'),
(23, 5, 'Social Media Owner', 18, '2024-04-01'),
(24, 5, 'Content Owner', 16, '2024-04-01'),
(25, 5, 'SEO Owner', 12, '2024-04-03'),
(5, 5, 'Project Sponsor', 5, '2024-04-01'),
(26, 6, 'Knowledge Base Owner', 18, '2024-02-15'),
(27, 6, 'Ticket Testing', 14, '2024-02-15'),
(28, 6, 'Technical Documentation', 16, '2024-02-18'),
(8, 6, 'UI Fixes', 8, '2024-03-01'),
(21, 8, 'Finance Report Owner', 15, '2024-03-01'),
(20, 8, 'Expense Audit', 12, '2024-03-01'),
(4, 8, 'Project Sponsor', 5, '2024-03-01'),
(13, 9, 'Customer Outreach', 16, '2024-05-01'),
(15, 9, 'Customer Interviews', 12, '2024-05-01'),
(26, 9, 'Support Feedback Owner', 10, '2024-05-03'),
(27, 9, 'Follow-up Owner', 10, '2024-05-03'),
(10, 10, 'Infrastructure Review', 12, '2023-07-01'),
(7, 10, 'Secure API Review', 10, '2023-07-01'),
(11, 10, 'Test Plan Owner', 10, '2023-07-05'),
(1, 10, 'Project Sponsor', 4, '2023-07-01');

SELECT setval(pg_get_serial_sequence('departments', 'id'), (SELECT MAX(id) FROM departments));
SELECT setval(pg_get_serial_sequence('employees', 'id'), (SELECT MAX(id) FROM employees));
SELECT setval(pg_get_serial_sequence('projects', 'id'), (SELECT MAX(id) FROM projects));
