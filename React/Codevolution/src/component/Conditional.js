import React from "react";

function Conditional() {
    const isLoggedin = false;
    return (
        <div>
            <h1>Conditional Component</h1>
            {isLoggedin ? <h3>Admin Login</h3> : <h3>Guest Login</h3>}  
        </div>
    )
}

function ConditionalShortCircuit() {
    const isLoggedin = true;
    return (
        <div>
            <h1>Conditional Component</h1>
            {isLoggedin && <h3>Admin Login</h3>} {/*isLogged in true it will work*/}
        </div>
    )
}

function ConditionalIfElse() {
    const isLoggedin = true;
    if (isLoggedin) {
        return (
            <div>
                <h1>Conditional Component</h1> 
                <h3>Admin Login</h3> {/*isLogged in true it will work*/}
            </div>
        );
    } else {
        return (
            <div>
                <h1>Conditional Component</h1>
                <h3>Guest Login</h3> {/*isLogged in false it will work*/}
            </div>
        )
    }
}

export default Conditional;
export { ConditionalShortCircuit, ConditionalIfElse };