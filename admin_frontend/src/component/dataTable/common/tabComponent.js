import React from 'react';

import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import TabPanel from '../common/tabPanel'

const tabs = [
    {id: 'tab1', displayName: "Tab 1", index: 0, content: {
        text: "i am tab 1"
    }}, 
    {id: 'tab2', displayName: "Tab 2", index: 1, content: {
        text: "i am tab 2"
    }},
    {id: 'tab3', displayName: "Tab 3", index: 2,content: {
        text: "i am tab 3"
    }}
]


export default function TabComponent(props){
    const [value, setValue] = React.useState(0);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <div>
        <Tabs value={value} onChange={handleChange} aria-label="simple tabs example">
          {tabs.map( (tab) => (
              <Tab label={tab.displayName}  />
          ))}
        </Tabs>
        {tabs.map( (tab) => (
              <TabPanel value={value} index={tab.index} content={tab.content.text}/>
          ))}
        </div>  
    )

}