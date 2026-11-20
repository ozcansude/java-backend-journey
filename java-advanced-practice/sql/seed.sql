INSERT INTO categories(category_id, category_name)
VALUES (1,'Market'),
        (2,'Eğlence'),
        (3,'Ulaşım'),
        (4,'Faturalar'),
        (5,'Sağlık');

INSERT INTO expenses(expense_id, category_id, expense_amount, description)
VALUES(1, 1, 1250.50, 'Haftalik market alisverisi'),
(2, 2, 350.00, 'Sinema bileti'),
(3, 3, 120.00, 'Otobus ve metro'),
(4, 4, 4500.00, 'Aylik kira'),
(5, 5, 275.00, 'Eczane harcamasi'),
(6, 1, 680.75, 'Temel gida alisverisi'),
(7, 2, 200.00, 'Oyun satin alma'),
(8, 3, 250.00, 'Taksi ucreti'),
(9, 4, 850.00, 'Elektrik ve su faturasi'),
(10, 5, 600.00, 'Doktor muayenesi'),
(11, 1, 320.00, 'Temizlik urunleri'),
(12, 3, 600.00, 'Aylik ulasim karti');


--CHECK VE FOREIGN KEY'İN GERÇEKTEN ÇALIŞTIĞINI HATALI INSERT İLE GÖSTER
INSERT INTO expenses(expense_id, category_id, expense_amount, description)
VALUES (13,3,-100,'Otobüs ve metro') ;

INSERT INTO expenses(expense_id, category_id, expense_amount, description)
VALUES (14,10,300,'Metro');
------- BU İKİ ÖRNEK HATALI, DOLAYISIYLA EXPENSE TABLOMU SORGULADIĞIMDA BU İKİSİ ORADA OLMAMALI


INSERT INTO expenses(expense_id, category_id, expense_amount, description)
VALUES (13,3,200,'Metro');

INSERT INTO categories(category_id, category_name)
VALUES (6,'Yeme-içme');