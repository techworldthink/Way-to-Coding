import React, {Component} from "react";

class CountState extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0
        };
    }

    increment = () => {
        this.setState({
            count: this.state.count + 1
        });
    }

    render() {
        return (
        <div>
            <h1>CountState Component</h1>
            <h3>Count: {this.state.count}</h3>
            <button onClick={() => this.increment()}>Increment</button>
            <button onClick={() => this.setState({count: this.state.count - 1})}>Decrement</button>
        </div>
        );
    }
}

export default CountState;