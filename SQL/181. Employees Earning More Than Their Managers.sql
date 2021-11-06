select ee.name as employee
from employee e
join employee ee
on e.id = ee.managerId And e.salary < ee.salary