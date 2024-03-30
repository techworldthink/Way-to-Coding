## Loops

```js
// List.js 

import React, { Component } from "react";

export default class List extends Component {
  state = {
    data: [
      {
        id: 101,
        name: "abc",
      },
      {
        id: 102,
        name: "bcv",
      },
    ],
  };
  render() {
    return (
      <div>
        {this.state.data.map((value, index) => {
          return (
            <li key={index}>
              {value.id} - {value.name}
            </li>
          );
        })}
      </div>
    );
  }
}

```