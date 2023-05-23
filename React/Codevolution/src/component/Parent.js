import React from "react";
import Child from "./Child";

const Parent = () => {
    const nameParent="Parent";
    const greetParent = (child ) => {
        alert("Hello " +nameParent+ " from " +child);
    }

    return (
        <div>
            <Child parentName={greetParent} />
        </div>
    );
} 
export default Parent;