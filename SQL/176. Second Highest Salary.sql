select max(salary) as SecondHighestSalary
from Employee
where salary not in (
    select max(salary)
    from Employee
 )