import React, { Component } from 'react';
import EmployeeTable from './EmployeeTable';

class EmployeeV3 extends Component {
    render() {
        return (
            <EmployeeTable employeesArr={this.state.employeeArr} />
        );

    }
    state = {
        employeeArr: [],

    }
    componentDidMount() {
        fetch('http://localhost:8080/employees/all', {
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
        })
            .then(res => res.json())
            .then((data) => {
                this.setState({ employeeArr: data })
                console.log(data);
                console.log(this.state.employeesArr);
            })
            .catch(console.log)
    }
}

export default EmployeeV3;