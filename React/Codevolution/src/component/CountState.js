import React from "react";

function Count() {
    const [count, setCount] = React.useState(0); // 0 is the initial value of count

    const increment = () => {
        setCount(count + 1); // setCount is a function that takes a value and updates the state
    }
    return (
        <div>
        <h1>Count Component</h1>
        <h3>Count: {count}</h3>
        <button onClick={() => increment()}>Increment</button> {/* onClick is an event handler that calls the increment function */}
        </div>
    );
}

export default Count;