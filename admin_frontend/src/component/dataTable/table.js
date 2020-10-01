import React from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';


export default function BasicTable(props) {

  return (
    <TableContainer component={Paper}>
      <Table  aria-label="simple table">
        <TableHead>
          {props.columns.map( (column) => ( <TableCell align="center">{column.headerName}</TableCell>  ) )}
        </TableHead>
        <TableBody>
          {props.rows.map((row) => (
            <TableRow key={row[props.columns[0].field]}>
                {props.columns.map( (column) => ( <TableCell align="center">{row[column.field]}</TableCell>  ) )}
            </TableRow>
          ))}
          
        </TableBody>
      </Table>
    </TableContainer>
  );
}
