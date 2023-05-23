import React from "react";

const Child = (props) => {
    return (
        <div>
            <h1>Child Component</h1>
            <button onClick={() => props.parentName("Child") }>Greet Parent</button>
        </div>
    );
}

export default Child;