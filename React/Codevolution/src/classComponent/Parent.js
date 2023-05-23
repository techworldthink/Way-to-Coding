import React,{Component} from "react";
import Child from "./Child";

class Parent extends Component {
    constructor() {
        super();
        this.state = {
            nameParent: "Parent",
        }

        this.greetParent = this.greetParent.bind(this);
    }
    greetParent = (child) => {
        alert(`Hello ${this.state.nameParent} from ${child}s`);
    }

    render() {
        return (
            <div>
                <Child parentName={this.greetParent} />
            </div>
        );
    }
}

export default Parent;
