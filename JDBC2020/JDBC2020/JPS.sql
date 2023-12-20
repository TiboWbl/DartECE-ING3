CREATE TABLE  `Mission` (
`missno` INT NOT NULL PRIMARY KEY ,
`empno` INT NOT NULL ,
`ciename` TEXT NOT NULL ,
`local` TEXT NOT NULL ,
`enddate` DATE NOT NULL
) ENGINE = INNODB;

CREATE TABLE  `Emp` (
`empno` INT NOT NULL PRIMARY KEY ,
`ename` TEXT NOT NULL ,
`job` TEXT NOT NULL ,
`mgr` INT NULL ,
`hiredate` DATE NOT NULL,
`sal` INT NOT NULL ,
`comm` INT NULL ,
`deptno` INT NOT NULL
) ENGINE = INNODB;

CREATE TABLE  `Dept` (
`deptno` INT NOT NULL  PRIMARY KEY ,
`dname` TEXT NOT NULL ,
`loc` TEXT NOT NULL
) ENGINE = INNODB;

ALTER TABLE Emp ADD FOREIGN KEY (deptno) REFERENCES Dept(deptno);
ALTER TABLE Emp ADD FOREIGN KEY (mgr) REFERENCES Emp(empno);
ALTER TABLE Mission ADD FOREIGN KEY (empno) REFERENCES Emp(empno);

-- Remplir table DEPT

INSERT INTO  `Dept` (`deptno` ,`dname` ,`loc`) VALUES 
('10',  'Accounting',  'New-York'),
('20',  'Research',  'Dallas'),
('30',  'Sales',  'Chicago'),
('40',  'Operations',  'Boston');

-- Remplir Table EMP

INSERT INTO  `Emp` (`empno` ,`ename` ,`job` ,`mgr` ,`hiredate` ,`sal` ,`comm` ,`deptno`)
VALUES 
('7839',  'King',  'President',  NULL,  '1981-11-17',  '5000', NULL ,  '10'),
('7782',  'Clark',  'Manager',  '7839',  '1981-06-09',  '2450', NULL ,  '10'),
('7698',  'Blake',  'Manager',  '7839',  '1981-05-01',  '2800', NULL ,  '30'),
('7566',  'Jones',  'Manager',  '7839',  '1981-04-02',  '2975', NULL ,  '20'),
('7788',  'Scott',  'Analyst',  '7566',  '1981-11-09',  '3000', NULL ,  '20'),
('7902',  'Ford',  'Analyst',  '7566',  '1981-12-03',  '3000', NULL ,  '20'),
('7876',  'Adams',  'Clerk',  '7788',  '1981-09-23',  '1100', NULL ,  '20'),
('7934',  'Miller',  'Clerk',  '7782',  '1982-01-23',  '1300', NULL ,  '10'),
('7900',  'James',  'Clerk',  '7698',  '1981-12-03',  '950', NULL ,  '30'),
('7844',  'Turner',  'Salesman',  '7698',  '1981-09-08',  '1500', '0' ,  '30'),
('7654',  'Martin',  'Salesman',  '7698',  '1981-09-28',  '1250', '1400' ,  '30'),
('7521',  'Ward',  'Salesman',  '7698',  '1981-02-22',  '1250', '500' ,  '30'),
('7499',  'Allen',  'Salesman',  '7698',  '1981-02-20',  '1600', '300' ,  '30'),
('7369',  'Smith',  'Clerk',  '7902',  '1981-12-17',  '800', NULL ,  '20');

-- Remplir table mission

INSERT INTO `Mission` (`missno`,`empno`,`ciename`,`local`,`enddate`) VALUES
('209', '7654' ,'BMW'		, 'Berlin'	, '2001-02-09'),
('212', '7698' ,'MacDo'		, 'Chicago' , '2001-03-04'),
('213', '7902' ,'Oracle'	, 'Dallas'  , '2001-04-11'),
('214', '7900' ,'FIDAL'		, 'Paris'   , '2001-06-07'),
('216', '7698' ,'IBM'		, 'Chicago' , '2001-02-09'),
('218', '7499' ,'Décathlon'	, 'Clermont', '2002-12-24'),
('219', '7782' ,'BMW'		, 'Chicago'	, '2001-08-16');