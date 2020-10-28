import React from 'react';
import Modal from '@material-ui/core/Modal';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    paper: {
      position: 'absolute',
      width: 400,
      backgroundColor: theme.palette.background.paper,
      border: '2px solid #000',
      boxShadow: theme.shadows[5],
      padding: theme.spacing(2, 4, 3),
    },
  }));


export default function SimpleModal(props){
    const classes = useStyles();

    return (
        <div>
            <Modal open={props.show} onClose={props.handleModalClose} aria-labelledby="simple-modal-title" aria-describedby="simple-modal-description" >
            <div className={classes.paper}>
            <h2 id="simple-modal-title"> {props.title} </h2>
                {props.body}   
            </div>
            </Modal>
        </div>
        
    )

}