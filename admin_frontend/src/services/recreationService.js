import React from 'react'

export const RecreationService = () => {



    const getPopulatedElementWithNewProps = (reactElement, props) =>{
        return React.cloneElement(
            reactElement,
            props
          )
    }

    return {
        getPopulatedElementWithNewProps
    }

}