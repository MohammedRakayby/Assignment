import React from 'react'
import MaterialTable from 'material-table';

function saveEmployee(rowData){
    console.log(rowData);
}
function deleteEmployee(rowData){
    console.log(rowData);
}
function editEmployee(rowData){
    console.log(rowData);
}
const EmployeeTable = ({ employeesArr }) => {
    const columns = [
        { title: 'First Name', field: 'firstName' },
        { title: 'Last Name', field: 'lastName' },
        { title: 'Email', field: 'email' },
        { title: 'Phone Number', field: 'phoneNumber', type: 'numeric' },
        { title: 'Hiring Date', field: 'hiringDate', type: 'date' },
        { title: 'Salary', field: 'salary', type: 'numeric' },
        { title: 'Department Id', field: 'managerId', type: 'numeric' },
        { title: 'Manager Id', field: 'departmentId', type: 'numeric' },
    ]


    return (<MaterialTable
        title="Employees"
        columns={columns}
        data={employeesArr}
        actions={[
            {
                icon: 'save',
                tooltip: 'Save User',
                onClick: (event, rowData) => { if (window.confirm("Do you want to save " + rowData.firstName+' '+rowData.lastName)) saveEmployee(rowData);}
            },
            {
                icon: 'delete',
                tooltip: 'Delete User',
                onClick: (event, rowData) => { if (window.confirm("Delete " + rowData.firstName+' '+rowData.lastName+"?")) deleteEmployee(rowData);}
            },
            {
                icon: 'edit',
                tooltip: 'edit User',
                onClick: (event, rowData) => { if (window.confirm("Do you want to save " + rowData.firstName+' '+rowData.lastName)) editEmployee(rowData);}
            }
        ]}
    />)
};
export default EmployeeTable; 