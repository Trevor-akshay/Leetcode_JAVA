select 
    D1.name as Department, 
    E1.name as Employee,
    E1.salary as Salary
from 
    Employee E1,
    Department D1
where E1.departmentId = D1.id 
      AND
      (E1.departmentId,E1.salary) in (
            Select E2.departmentId,Max(E2.Salary) 
            from Employee E2 
            group by E2.departmentId
      ) 
