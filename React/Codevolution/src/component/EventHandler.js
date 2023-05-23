import React from "react";
import {useState} from "react";

const EventHandler = (props) => {
    const  [welcome, setWelcome] = useState("Welcome to React"); // Event Handler using Hooks
    const fun =   props.name;
    const changeWelcome = () => {
        setWelcome("Thank you " + fun ); 
    }

    return (
        <div>
        <h1>EventHandler Component</h1>
        <h3>state: {welcome}</h3>
        <button onClick={ () => changeWelcome()}>Change</button>
        </div>
    );
}

export default EventHandler;
