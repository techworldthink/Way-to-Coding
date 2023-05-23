import React, { Component } from 'react'

class ConditionalIfElse extends Component {
    constructor() {
        super();
        this.state = {
            isLoggedIn: true,
        }
    }

    render() {
        if (this.state.isLoggedIn) {
            return (
                <div>
                    <h1>Conditional Component</h1>
                    <h3>Admin Login</h3>
                </div>
            );
        }else{
            return (
                <div>
                    <h1>Conditional Component</h1>
                    <h3>Guest Login</h3>
                </div>
            )
        }
    }
}

class ConditionalTernary extends Component {
    constructor() {
        super();
        this.state = {
            isLoggedIn: false,
        }
    }

    render() {
        return (
            <div>
                <h1>Conditional Component</h1>
                <h3>{this.state.isLoggedIn ? "Admin Login" : "Guest Login"}</h3>
            </div>
        );
    }
}

class ConditionalShortCircuit extends Component {
    constructor() {
        super();
        this.state = {
            isLoggedIn: true,
        }
    }

    render() {
        return (
            <div>
                <h1>Conditional Component</h1>
                {this.state.isLoggedIn && <h3>Admin Login</h3>}
            </div>
        );
    }
}



export default ConditionalIfElse;
export {ConditionalTernary};
export {ConditionalShortCircuit};