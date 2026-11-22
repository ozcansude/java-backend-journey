
--sinema bileti fiyatını güncelle
UPDATE expenses
SET expense_amount = 650
WHERE expense_id = 2;

select *
from expenses
order by expense_id;

--taksi ücretini sil
DELETE FROM expenses
WHERE expense_id =  8;

SELECT e.expense_id, c.category_name,description
FROM expenses e
    LEFT JOIN categories c
        on e.category_id = c.category_id;

--kategori bazında toplam harcama
SELECT c.category_name,SUM(e.expense_amount)
FROM categories c
    LEFT JOIN expenses e on c.category_id = e.category_id
GROUP BY c.category_id;

--En yüksekten en düşük harcamaya sırala
SELECT *
FROM expenses e
ORDER BY e.expense_amount DESC;

select *
from categories;

delete from expenses
where expense_id = 24;

select*
from expenses e
left join categories c on e.category_id = c.category_id
order by e.expense_id;

INSERT INTO expenses
    (expense_id, category_id, expense_amount)
VALUES (6, 1,781);

delete from expenses
where expense_id = 36;