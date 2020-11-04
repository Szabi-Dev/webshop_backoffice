import React from 'react';

export default function TabPanel(props) {
    const { children, value, index, content, ...other } = props;
  
    return (
      <div role="tabpanel" hidden={value !== index} id={`simple-tabpanel-${index}`} aria-labelledby={`simple-tab-${index}`} {...other} >
        {value === index && (
            <p>
                {content}
            </p>
        )}
      </div>
    );
  }