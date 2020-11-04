import React from 'react';
import MenuItem from '@material-ui/core/MenuItem';
import DeleteModal from '../modal/deleteModal';

const tableMenuItem = {field: "delete", name: "Delete"}

export default function DeleteMenuItem(props) {
    const [isOpen, setIsOpen] = React.useState(false);

    const openModal = () => {
        setIsOpen(true);
    }

    const closeModal = () => {
        setIsOpen(false)
        props.handleClose()
        props.handleResponse()
    }


    return (
        <div>
            <MenuItem onClick={openModal}> {tableMenuItem.name}</MenuItem>
            <DeleteModal show={isOpen} handleModalClose={closeModal} actionLink={props.actionLink}/> 
        </div>
    )
}