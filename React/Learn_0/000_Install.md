# How To Install React
### 1. Install Node.js and npm
https://nodejs.org/en/download/

### 2. Verify installation
```bash
node -v npm -v
```
### 3. Install Create React App
```bash
npm install -g create-react-app
```
### 4.Create a New React Project
```bash
npx create-react-app my-app
```

### 5. Run
```bash
cd my-app

npm start
```

<br><br>


# Initial Cleanup Guide for a Newly Created React Project
When you create a new React project using `create-react-app`, it comes with some boilerplate files and code that you might not need for your project. Here's a list of files and content you can safely remove or modify initially:

---

### 1. **Files to Remove**
- **`logo.svg`**:  
  The React logo file. If you don't need the default logo, you can delete this file from the `src` folder.
- **`App.css`**:  
  The default CSS file for the `App` component. If you're not using it, you can delete it.
- **`App.test.js`**:  
  The default test file for the `App` component. Remove this if you're not writing tests immediately or using a different testing strategy.
- **`reportWebVitals.js`**:  
  Used for measuring performance metrics. If you don't plan to use this feature, you can delete this file.
- **`setupTests.js`**:  
  Contains configurations for testing libraries like Jest. Remove it if you're not using tests right now.

---

### 2. **Code to Modify**
- **`App.js`**:  
  The boilerplate code in `App.js` contains React logo and some initial content. Replace it with your component's content or your starting UI.
- **`index.css`**:  
  Contains default styles. Either remove unused styles or replace them with your custom CSS.
- **`manifest.json`**:  
  If you're not building a Progressive Web App (PWA), you can remove unused properties or the file itself.
- **`favicon.ico`**:  
  Replace it with your custom favicon or delete it if unnecessary.

---

### 3. **Steps After Cleanup**
- Update `index.js` to remove references to deleted files:
  ```javascript
  import React from 'react';
  import ReactDOM from 'react-dom';
  import './index.css'; // Update or remove if unused
  import App from './App'; 

  ReactDOM.render(
    <React.StrictMode>
      <App />
    </React.StrictMode>,
    document.getElementById('root')
  );
  ```
- Remove references to `reportWebVitals`:
  ```javascript
  // Remove this line if reportWebVitals.js is deleted
  // import reportWebVitals from './reportWebVitals';
  ```

---

### 4. **Updated Folder Structure**
After cleanup, your `src` folder might look like this:

```
src/
├── App.js
├── index.js
└── index.css (optional)
```

This cleanup makes the project lighter and focuses on your specific requirements.