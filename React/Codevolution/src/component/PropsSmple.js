import React from "react";

const PropsSmple = (props) => { // props is a keyword and can be any name
    return (
        <div>
            <h1>PropsSmple Component</h1>
            <h3>props: {props.name} class :: {props.classRoom}</h3>  
            <p>{props.pg} </p>
        </div>
    );
}

export default PropsSmple;
