import React from 'react'
import MaterialTable from 'material-table';
import * as Constants from '../Defines/Constants'


class EmployeeTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            columns: [
                { title: 'First Name', field: 'firstName' },
                { title: 'Last Name', field: 'lastName' },
                { title: 'Email', field: 'email' },
                { title: 'Phone Number', field: 'phoneNumber' },
                { title: 'Hiring Date', field: 'hiringDate' },
                { title: 'Salary', field: 'salary', type: 'numeric' },
                { title: 'Department Id', field: 'departmentId', type: 'numeric' },
                { title: 'Manager Id', field: 'managerId', type: 'numeric' },
            ],
            data: []
        }

    };
    componentDidMount() {
        fetch(Constants.HOST_URL + Constants.EMPLOYEE_CONTROLLER + Constants.GET_ALL, {
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(json => {
                this.setState({ data: json });
            });
    }
    saveEmployee(newEmployee) {
        console.log('Creating Employee' + JSON.stringify(newEmployee));
        fetch(Constants.HOST_URL + Constants.EMPLOYEE_CONTROLLER + Constants.CREATE,
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(newEmployee)
            })
    }
    deleteEmployee(deletedEmployee) {
        console.log('Deleting Employee' + JSON.stringify(deletedEmployee));
        fetch(Constants.HOST_URL + Constants.EMPLOYEE_CONTROLLER + Constants.DELETE + '?employeeId=' + deletedEmployee.id, {
            headers: { Accept: 'application/json', 'Content-Type': 'application/json' }
        })
    }
    editEmployee(editedEmployee) {
        console.log('Editing Employee ' + JSON.stringify(editedEmployee));
        fetch(Constants.HOST_URL + Constants.EMPLOYEE_CONTROLLER + Constants.UPDATE + '?employeeId=' + editedEmployee.id, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(editedEmployee)
        })
    }

    validateEmployee(employee) {
        var numPattern = /^[0-9-]+$/;
        if (!employee.firstName || employee.firstName === "" || employee.firstName.length < 2) {
            alert('First Name cannot be null or empty and must be longer than 2 characters');
            return false;
        } else if (!employee.lastName || employee.lastName === "" || employee.firstName.length < 2) {
            alert('Last Name cannot be null or empty and must be longer than 2 characters');
            return false;
        } else if (employee.salary <= 0) {
            alert('Salary cannot be empty or zero');
            return false;
        } else if (!numPattern.test(employee.phoneNumber)) {
            alert('Phone Number must contain only numbers and dashs');
            return false;
        } else if (!this.isValidDate(employee.hiringDate)) {
            alert('Hiring date is invalid, date format should DD/MM/YYYY')
            return false;
        }
        else {
            return true;
        }
    }
    isValidDate(dateString) {
        debugger;
        if (!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(dateString))
            return false;

        var parts = dateString.split("/");
        var day = parseInt(parts[0], 10);
        var month = parseInt(parts[1], 10);
        var year = parseInt(parts[2], 10);

        if (year < 1950 || year > 2019 || month == 0 || month > 12 || day < 1 || day > 31)
            return false;
    };
    render() {
        return (
            <MaterialTable
                title="Employees"
                columns={this.state.columns}
                data={this.state.data}
                editable={{
                    onRowAdd: newData =>
                        new Promise(resolve => {
                            setTimeout(() => {
                                resolve();
                                this.setState(prevState => {
                                    if (this.validateEmployee(newData)) {
                                        const data = [...prevState.data];
                                        data.push(newData);
                                        this.saveEmployee(newData);
                                        return { ...prevState, data };
                                    } else {
                                        return { ...prevState, ...prevState.data }
                                    }
                                });
                            }, 200);
                        }),
                    onRowUpdate: (newData, oldData) =>
                        new Promise(resolve => {
                            setTimeout(() => {
                                resolve();
                                this.setState(prevState => {
                                    if (this.validateEmployee(newData)) {
                                        const data = [...prevState.data];
                                        data[data.indexOf(oldData)] = newData;
                                        this.editEmployee(newData);
                                        return { ...prevState, data };
                                    } else {
                                        return { ...prevState, ...prevState.data };
                                    }
                                });
                            }, 200);
                        }),
                    onRowDelete: oldData =>
                        new Promise(resolve => {
                            setTimeout(() => {
                                resolve();
                                this.setState(prevState => {
                                    const data = [...prevState.data];
                                    data.splice(data.indexOf(oldData), 1);
                                    this.deleteEmployee(oldData);
                                    return { ...prevState, data };
                                });
                            }, 200);
                        }),
                }}
            />
        );
    }

}
export default EmployeeTable; 