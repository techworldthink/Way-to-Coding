import React,{Component} from "react";

class StateExmpl extends Component {
    constructor() {
        super();
        this.state = {
            welcome: "Welcome to React",
        }
    }

    changeWelcome = () => {
        this.setState({
            welcome: "Thank you " + this.props.name,
        })
    }

    render() {
        return (
            <div>
                <h1>StateExmpl Component</h1>
                <h3>state: {this.state.welcome}</h3>
                <button onClick={this.changeWelcome}>Change</button>
            </div>
        );
    }
}

export default StateExmpl;