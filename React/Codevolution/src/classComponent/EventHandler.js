import React,{Component} from "react";


class EventHandler extends Component {
    constructor(props) {
        super(props);
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
                <h1>Event Handler</h1>
                <h3>state: {this.state.welcome}</h3>
                <button onClick={ () => this.changeWelcome()}>Change</button>
            </div>
        );
    }
}



export default EventHandler;