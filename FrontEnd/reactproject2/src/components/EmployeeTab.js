import React from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const StyledTableCell = withStyles(theme => ({
    head: {
        backgroundColor: theme.palette.common.black,
        color: theme.palette.common.white,
    },
    body: {
        fontSize: 14,
    },
}))(TableCell);

const StyledTableRow = withStyles(theme => ({
    root: {
        '&:nth-of-type(odd)': {
            backgroundColor: theme.palette.background.default,
        },
    },
}))(TableRow);

function createData(name, email, phoneNumber, hiringDate, Salary, DepartmentId) {
    return { name, email, phoneNumber, hiringDate, Salary, DepartmentId };
}

const rows = [
    createData('Hamada', "toto@koko", 132165413, "11/12/2018", 12131, 5),
    createData('Zabadi', "toto@koko", 132165413, "11/12/2018", 12131, 5),
    createData('OK', "toto@koko", 132165413, "11/12/2018", 12131, 5),
    createData('Test', "toto@koko", 132165413, "11/12/2018", 12131, 5),
    createData('PLPLP', "toto@koko", 132165413, "11/12/2018", 12131, 5),
];

const useStyles = makeStyles({
    root: {
        width: '100%',
        overflowX: 'auto',
    },
    table: {
        minWidth: 700,
    },
});

export default function EmplyeesTab() {
    const classes = useStyles();

    return (
        <Paper className={classes.root}>
            <Table className={classes.table} aria-label="customized table">
                <TableHead>
                    <TableRow>
                        <StyledTableCell>Employees</StyledTableCell>
                        <StyledTableCell align="right">Email</StyledTableCell>
                        <StyledTableCell align="right">Phone Number</StyledTableCell>
                        <StyledTableCell align="right">Hiring Date</StyledTableCell>
                        <StyledTableCell align="right">Salary</StyledTableCell>
                        <StyledTableCell align="right">Department ID</StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map(row => (
                        <StyledTableRow key={row.name}>
                            <StyledTableCell component="th" scope="row">
                                {row.name}
                            </StyledTableCell>
                            <StyledTableCell align="right">{row.email}</StyledTableCell>
                            <StyledTableCell align="right">{row.phoneNumber}</StyledTableCell>
                            <StyledTableCell align="right">{row.hiringDate}</StyledTableCell>
                            <StyledTableCell align="right">{row.Salary}</StyledTableCell>
                            <StyledTableCell align="right">{row.DepartmentId}</StyledTableCell>
                        </StyledTableRow>
                    ))}
                </TableBody>
            </Table>
        </Paper>
    );
}