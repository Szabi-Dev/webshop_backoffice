import React from 'react';
import MenuItem from '@material-ui/core/MenuItem';
import EditModal from '../modal/editModal';
import { RecreationService } from '../../../services/recreationService';

const tableMenuItem = {field: "edit", name: "Edit"}

export default function EditMenuItem(props) {
    const [isOpen, setIsOpen] = React.useState(false);

    const openModal = () => {
        setIsOpen(true);
        props.editTabs.map( (editTab) => (
            editTab.content = RecreationService()
            .getPopulatedElementWithNewProps(editTab.content, {currentItem: props.currentItem})
        ))
    }

    const closeModal = () => {
        setIsOpen(false)
    }

    return (
        <div>
            <MenuItem onClick={openModal}> {tableMenuItem.name}</MenuItem>
            <EditModal show={isOpen} handleModalClose={closeModal} actionLink={props.actionLink} tabs={props.editTabs}/> 
       </div>
    )
}