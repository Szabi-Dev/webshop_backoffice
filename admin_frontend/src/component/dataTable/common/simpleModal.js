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
    const [isOpen, setIsOpen] = React.useState(false)
    const classes = useStyles();

    const openModal = () => {
        setIsOpen(true)
    }

    const closeModal = () => {
        setIsOpen(false)
    }

    return (
        <div>
            <button onClick={openModal}>{props.buttonText}</button>
            <Modal open={isOpen} onClose={closeModal} aria-labelledby="simple-modal-title" aria-describedby="simple-modal-description" >
            <div className={classes.paper}>
            <h2 id="simple-modal-title"> {props.title} </h2>
                
            </div>
            </Modal>
        </div>
        
    )

}