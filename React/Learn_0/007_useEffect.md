Sure! Here's the text printed in a clean format for your reference:

---

**In React, `useEffect` is a Hook** that allows you to perform side effects in function components. Side effects are operations that can affect other components or systems outside the scope of the component, such as data fetching, subscriptions, or manually changing the DOM.

### Basic Syntax:
```javascript
useEffect(() => {
  // Code to run on component mount or when dependencies change

  return () => {
    // Cleanup function (optional)
  };
}, [dependencies]);
```

- **Effect Function**: The first argument is the function that runs after the component renders. It can include side-effect logic like data fetching, subscriptions, or DOM manipulations.
- **Cleanup Function**: The optional return function is used to clean up any side effects (e.g., unsubscribing from an API or removing event listeners) when the component unmounts or before the effect runs again.
- **Dependencies Array**: The second argument is an array of dependencies, which tells React when to re-run the effect. If the dependencies haven't changed, React skips running the effect. If this argument is omitted, the effect will run after every render.

---

### Common Usage Patterns:

#### 1. **Run once after the initial render (componentDidMount equivalent):**
If you want the effect to run only once after the component mounts, pass an empty dependency array `[]`:
```javascript
useEffect(() => {
  console.log("Component mounted");
}, []); // Runs only once after the first render
```

#### 2. **Run after every render (componentDidUpdate equivalent):**
If you want the effect to run after every render, you can omit the dependency array, and React will run the effect after each render:
```javascript
useEffect(() => {
  console.log("Component rendered");
}); // Runs after every render
```

#### 3. **Run when specific state or props change:**
If you only want the effect to run when certain state or props change, you can specify them in the dependency array:
```javascript
useEffect(() => {
  console.log("Count changed:", count);
}, [count]); // Runs when `count` changes
```

#### 4. **Cleanup after the effect:**
You can return a cleanup function to undo any side effects when the component unmounts or when the dependencies change:
```javascript
useEffect(() => {
  const timer = setInterval(() => {
    console.log("Timer running...");
  }, 1000);

  // Cleanup function
  return () => {
    clearInterval(timer); // Clears the timer when the component unmounts
  };
}, []); // Runs once on mount and cleanup on unmount
```

---

### Example: Fetching Data
```javascript
import { useState, useEffect } from 'react';

function FetchData() {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('https://api.example.com/data');
        const result = await response.json();
        setData(result);
      } catch (error) {
        console.error('Error fetching data:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []); // Runs once on mount

  if (loading) return <div>Loading...</div>;
  return <div>Data: {JSON.stringify(data)}</div>;
}
```

---

### Key Points:
1. `useEffect` runs after the render (not during), so it's perfect for side effects that don’t directly affect the UI.
2. You can control when the effect runs by specifying dependencies.
3. Returning a cleanup function inside `useEffect` helps with cleaning up side effects like subscriptions or timers.

---

Would you like more details on a specific part of `useEffect` or another example?