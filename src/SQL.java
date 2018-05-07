
public class SQL {
	//CombineTwoTables
	//Left Join of two tables
	//SELECT Person.FirstName, Person.LastName, Address.City, Address.State 
	//from Person LEFT JOIN Address on Person.PersonId = Address.PersonId;
	
	//*****************************
	//Second Highest Salary
	//SELECT max(Salary) as 'SecondHighestSalary' FROM Employee WHERE Salary < (SELECT max(Salary) FROM Employee)
	
	//*****************************
	//Employees Earning More Than Their Managers
	//select a.Name as 'Employee' from Employee a inner join Employee b on a.ManagerId = b.Id where a.Salary > b.Salary
	//faster
	//select a.Name Employee from Employee a inner join (select distinct Id, Salary from Employee) b 
	//on a.ManagerId = b.Id where a.Salary > b.Salary; 
	
	//*****************************
	// Duplicate Emails
	// select Email from Person group by Email having count(Email) > 1
	
	//*****************************
	// Customers Who Never Order
	// SELECT A.Name as 'Customers' from Customers A LEFT JOIN Orders B on  a.Id = B.CustomerId WHERE b.CustomerId is NULL
	
	//**************************************
	//Delete duplicate Emails
	//Write a SQL query to delete all duplicate email entries in a table named Person, 
	//keeping only unique emails based on its smallest Id
	//	DELETE p1
	//	FROM Person p1, Person p2
	//	WHERE p1.Email = p2.Email AND
	//	p1.Id > p2.Id
	
	//**************************************
	//Rising Temperature
	// Given a Weather table, write a SQL query to find all dates' Ids with higher temperature
	// compared to its previous (yesterday's) dates.
	//	select w2.Id
	//	from Weather w1, Weather w2
	//	where DATEDIFF(w2.Date, w1.Date) = 1 AND
	//	      w2.Temperature > w1.Temperature
	
		
}
