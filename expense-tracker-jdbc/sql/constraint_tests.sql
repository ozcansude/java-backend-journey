-- Bu dosyadaki insert'ler BİLEREK hatalıdır.
-- CHECK ve FOREIGN KEY kısıtlarının gerçekten çalıştığını göstermek için.
-- Beklenen: ikisi de hata verir, expenses tablosuna hiçbir satır eklenmez.

-- 1) CHECK kısıtı: negatif tutar kabul edilmemeli
INSERT INTO expenses(expense_id, category_id, expense_amount, description)
VALUES (13, 3, -100, 'Otobüs ve metro');

-- 2) FOREIGN KEY kısıtı: olmayan bir category_id (10) kabul edilmemeli
INSERT INTO expenses(expense_id, category_id, expense_amount, description)
VALUES (14, 10, 300, 'Metro');