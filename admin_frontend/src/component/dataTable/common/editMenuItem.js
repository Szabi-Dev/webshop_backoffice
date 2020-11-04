import React, { useEffect } from 'react';
import MenuItem from '@material-ui/core/MenuItem';
import EditModal from '../modal/editModal';
import { RecreationService } from '../../../services/recreationService';

const tableMenuItem = {field: "edit", name: "Edit"}

export default function EditMenuItem(props) {
    const [isOpen, setIsOpen] = React.useState(false);
    const [currentItem, setCurrentItem] = React.useState({})

    const handleChange = (event) =>{
        currentItem[event.target.name] = event.target.value
        setCurrentItem(currentItem)
    }

    const openModal = () => {
        setIsOpen(true);
        let newProps = {
            currentItem: props.currentItem,
            handleEditChange : handleChange
        }

        props.editTabs.map( (editTab) => (
            editTab.content = RecreationService()
            .getPopulatedElementWithNewProps(editTab.content, newProps)
        ))

    }

    const closeModal = () => {
        setIsOpen(false)
        props.handleClose()
        props.handleResponse()
    }

    return (
        <div>
            <MenuItem onClick={openModal}> {tableMenuItem.name}</MenuItem>
            <EditModal show={isOpen} handleModalClose={closeModal} actionLink={props.actionLink} tabs={props.editTabs} payload={currentItem}/> 
       </div>
    )
}