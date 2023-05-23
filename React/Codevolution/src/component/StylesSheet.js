import React from 'react'
import './css/style.css'

import moduleStyles from './css/style.module.css'

function StylesSheet(props) {
    const heading = {
        fontOfSize: '72px',
        color: 'blue'
    }

    let successTrue =  props.name ? 'success' : '' //Conditional based stylesheet
    return (
        <div>
            <h1 style={heading}>Stylesheet</h1>  {/*Inline Style */}
            <p className={`${successTrue} backgd `}>
                if Conditional based stylesheet is required then use
            </p>
            <p className={moduleStyles.error}>Error</p> {/*Module based stylesheet */}
            <p className={moduleStyles.primary}>Primary</p> {/*Module based stylesheet */}
        </div>
    )
}

export default StylesSheet