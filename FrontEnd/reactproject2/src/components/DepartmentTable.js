import React from 'react'
import MaterialTable from 'material-table';
import * as Constants from '../Defines/Constants'


class DepartmentTable extends React.Component {
    //set department id to disabled
    constructor(props) {
        super(props);
        this.state = {
            columns: [
                { title: 'Department Id', field: 'id' },
                { title: 'Department Name', field: 'departmentName' },
                { title: 'Manager Id', field: 'managerId', type: 'numeric' },
            ],
            data: []
        }

    };
    componentDidMount() {
        fetch(Constants.HOST_URL + Constants.DEPARTMENT_CONTROLLER + Constants.GET_ALL, {
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
    saveDepartment(newDepartment) {
        console.log('Creating Department' + JSON.stringify(newDepartment));
        fetch(Constants.HOST_URL + Constants.DEPARTMENT_CONTROLLER + Constants.CREATE,
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(newDepartment)
            })
    }
    deleteDepartment(deletedDepartment) {
        console.log('Deleting Department' + JSON.stringify(deletedDepartment));
        fetch(Constants.HOST_URL + Constants.DEPARTMENT_CONTROLLER + Constants.DELETE + '?departmentId=' + deletedDepartment.id, {
            headers: { Accept: 'application/json', 'Content-Type': 'application/json' }
        })
    }
    editDepartment(editedDepartment) {
        console.log('Editing Department ' + JSON.stringify(editedDepartment));
        fetch(Constants.HOST_URL + Constants.DEPARTMENT_CONTROLLER + Constants.UPDATE + '?departmentId=' + editedDepartment.id, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(editedDepartment)
        })
    }

    render() {
        return (
            <MaterialTable
                title="Departments"
                columns={this.state.columns}
                data={this.state.data}
                editable={{
                    onRowAdd: newData =>
                        new Promise(resolve => {
                            setTimeout(() => {
                                resolve();
                                this.setState(prevState => {
                                    const data = [...prevState.data];
                                    data.push(newData);
                                    this.saveDepartment(newData);
                                    return { ...prevState, data };
                                });
                            }, 200);
                        }),
                    onRowUpdate: (newData, oldData) =>
                        new Promise(resolve => {
                            setTimeout(() => {
                                resolve();
                                if (oldData) {
                                    this.setState(prevState => {
                                        const data = [...prevState.data];
                                        data[data.indexOf(oldData)] = newData;
                                        this.editDepartment(newData);
                                    });
                                }
                            }, 200);
                        }),
                    onRowDelete: oldData =>
                        new Promise(resolve => {
                            setTimeout(() => {
                                resolve();
                                this.setState(prevState => {
                                    const data = [...prevState.data];
                                    data.splice(data.indexOf(oldData), 1);
                                    this.deleteDepartment(oldData);
                                    return { ...prevState, data };
                                });
                            }, 200);
                        }),
                }}
            />
        );
    }

}
export default DepartmentTable; 