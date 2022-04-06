DROP DATABASE IF EXISTS company_db;
CREATE DATABASE company_db;
USE company_db;

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
	`code` varchar(10) NOT NULL,
    `name` varchar(50) NOT NULL,
    `localization` varchar(50) NOT NULL,
    PRIMARY KEY (`code`)
);

INSERT INTO `department` VALUES 
    ("D-000-1", "Software", "Los Tigres"),
    ("D-000-2", "Sistemas", "Guadalupe"),
    ("D-000-3", "Contabilidade", "La Roca"),
    ("D-000-4", "Vendas", "Plata");

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
	`code` varchar(10) NOT NULL,
    `name` varchar(80) NOT NULL,
    `surname` varchar(80) NOT NULL,
    `role` varchar(100) NOT NULL,
    `updated_at` timestamp NULL DEFAULT NULL,
    `salary` decimal(10, 2) NOT NULL,
    `commission` decimal(10, 2) NOT NULL,
    `department_code` varchar(10) NOT NULL,
    PRIMARY KEY (`code`),
    CONSTRAINT `employee_depart_code_foreign` FOREIGN KEY (`department_code`) REFERENCES `department` (`code`)
);


INSERT INTO `employee` 
VALUES ("E-0001", "César", "Piñero", "Vendedor", "2018-05-12", 80000, 15000, "D-000-4"),
("E-0002", "Yosep", "Kowaleski", "Analista", "2015-07-14", 140000, 0, "D-000-2"),
("E-0003", "Mariela", "Barrios", "Diretor", "2014-06-05", 185000, 0, "D-000-3"),
("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-03", 85000, 10000, "D-000-4"),
("E-0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", 85000, 10000, "D-000-4"),
("E-0006", "Mito", "Barchuk", "Presidente", "2014-06-05", 190000, 0, "D-000-3"),
("E-0007", "Emilio", "Galarza", "Desenvolvedor", "2014-08-02", 60000, 0, "D-000-1");

/* Selecione o nome, cargo e localização dos departamentos onde os vendedores trabalham. */
SELECT emp.name, emp.role, depart.localization
FROM employee emp
INNER JOIN department depart ON emp.department_code = depart.code
WHERE emp.role = 'Vendedor';

/* Visualize departamentos com mais de cinco funcionários. */
SELECT COUNT(*) as employees, depart.name, depart.localization 
FROM employee emp
INNER JOIN department depart ON emp.department_code = depart.code
GROUP BY emp.department_code
HAVING employees > 5;

/* Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo cargo que 'Mito Barchuk'. */
SELECT emp.name, emp.salary, depart.name depart_name
FROM employee emp
INNER JOIN department depart ON emp.department_code = depart.code
WHERE emp.role = (SELECT role FROM employee WHERE name = 'Mito' AND surname = 'Barchuk');

/* Mostre os dados dos funcionários que trabalham no departamento de contabilidade, ordenados por nome. */
SELECT emp.name, emp.surname, emp.role, emp.salary, emp.commission
FROM employee emp
INNER JOIN department ON department.code = emp.department_code
WHERE department.name = 'Contabilidade'
ORDER BY (emp.name);

/* Mostre o nome do funcionário que tem o menor salário. */
SELECT name, surname
FROM employee
WHERE salary = (SELECT MIN(salary) FROM employee);

/* Mostre os dados do funcionário que tem o maior salário no departamento 'Vendas'. */
SELECT emp.name, emp.surname, emp.role, emp.salary, emp.commission, depart.name
FROM employee emp
INNER JOIN department depart ON emp.department_code = depart.code
AND emp.salary = (SELECT MAX(salary) FROM employee emp
INNER JOIN department depart ON emp.department_code = depart.code
WHERE depart.name = 'Vendas')
LIMIT 1;

-- Outra maneira de fazer
-- SELECT emp.name, emp.surname, emp.role, emp.salary, emp.commission
-- FROM employee emp
-- INNER JOIN department depart ON emp.department_code = depart.code AND depart.name = 'Vendas' 
-- ORDER BY (emp.salary) DESC
-- LIMIT 1;