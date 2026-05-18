

### A) Department Health Report
1. Her departman için şu bilgileri tek tabloda göster:
departman adı
lokasyon
çalışan sayısı
aktif çalışan sayısı
pasif çalışan sayısı
ortalama maaş
toplam maaş
yıllık bütçe
bütçe durumu: over_budget / budget_ok

### B) Project Workload Report
2. Her proje için şu bilgileri göster:
proje adı
proje durumu
departman adı
projede çalışan kişi sayısı
toplam haftalık saat
ortalama haftalık saat
proje aktif mi?
workload seviyesi:
low → 20 saat altı
medium → 20–40 arası
high → 40 üstü

### C) Employee Ranking Report
3. Her departmanda maaşa göre çalışanları sırala.

Kolonlar:

employee_name
department_name
salary
department_salary_rank
company_salary_rank

### D) Manager Analysis
4. Her manager için şunları göster:
manager adı
kaç kişi yönetiyor
yönettiği çalışanların ortalama maaşı
yönettiği çalışanların toplam proje saati
manager maaşı
manager seviyesi:
5+ kişi yönetiyorsa senior_manager
3–4 kişi yönetiyorsa manager
daha azsa team_lead

### E) Underloaded / Overloaded Employees
5. Çalışanları proje saatlerine göre sınıflandır:
0 saat → not_assigned
1–15 saat → underloaded
16–30 saat → normal
31+ saat → overloaded

Projesi olmayan çalışanlar da görünmeli.

### F) Above Department Average
6. Maaşı kendi departman ortalamasından yüksek olan çalışanları göster.

Ama bu kez şunları da ekle:

employee_name
department_name
salary
department_avg_salary
salary_difference
rank_in_department

### G) Active Project Talent Report
7. Aktif projelerde çalışan kişileri getir.

Ama şunları göster:

project_name
employee_name
employee_department
project_department
role
hours_per_week
salary
performance_score

### H) EXISTS / NOT EXISTS Mastery
8. Hiç aktif projede çalışmayan aktif çalışanları bul.

Yani çalışan aktif olabilir ama aktif projede görevi olmayabilir.

### I) Date Analysis
9. Her çalışan için şirkette çalışma süresini hesapla.

Kolonlar:

employee_name
hire_date
years_worked
employee_level_by_tenure:
0–1 yıl → new
2–4 yıl → experienced
5+ yıl → veteran

### J) View Task
10. Şu iki view’i oluştur:
CREATE VIEW department_health_report AS ...

ve

CREATE VIEW employee_workload_report AS ...

Sonra bu view’lerden sorgu at:

SELECT *
FROM department_health_report
WHERE budget_status = 'over_budget';
SELECT *
FROM employee_workload_report
WHERE workload_status = 'overloaded';








