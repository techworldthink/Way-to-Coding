import React,{Component} from "react";

class Child extends Component {


    render() {
        return (
            <div>
                <h1>Child Component</h1>
                <button onClick={() => this.props.parentName("Child")}>Greet Parent</button>
            </div>
        );
    }
}

export default Child;