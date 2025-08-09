# Janitri Dashboard Login Page – Test Cases  

**Task:**  
👉 *"Write as many test cases as possible for the login page of the Janitri Dashboard."*  

**URL:** [https://dev-dash.janitri.in](https://dev-dash.janitri.in)  

**Instructions:**  
- Cover both **positive** and **negative** scenarios  
- Include **functional** and **UI** checks  

---

## 📋 Test Cases  

| **TC ID** | **Test Scenario** | **Test Steps** | **Expected Result** | **Type** |
|-----------|------------------|----------------|---------------------|----------|
| TC001 | Valid login | Enter valid email & password → Click **Login** | User successfully logs in & dashboard is displayed | Positive |
| TC002 | Invalid password | Enter valid email & invalid password → Click **Login** | Error message “Invalid Credentials” is displayed | Negative |
| TC003 | Invalid email format | Enter invalid email (e.g. `abc@`) → Click **Login** | Validation message “Please enter a valid email” appears | Negative |
| TC004 | Email field empty | Keep email field empty → Enter valid password → Click **Login** | Validation message “Email is required” appears | Negative |
| TC005 | Password field empty | Enter valid email → Keep password field empty → Click **Login** | Validation message “Password is required” appears | Negative |
| TC006 | Both fields empty | Leave both fields empty → Click **Login** | Validation message “Email and password are required” appears | Negative |
| TC007 | Password masking | Enter password → Verify it is masked (●●●●●) | Password should be hidden by default | Positive |
| TC008 | Show password toggle | Enter password → Click **eye icon** | Password becomes visible | Positive |
| TC009 | Hide password toggle | Click **eye icon** again | Password becomes hidden | Positive |
| TC010 | Login button disabled with empty fields | Keep both fields empty → Check Login button state | Login button should remain disabled | Negative |
| TC011 | Leading/trailing spaces in email | Enter email with spaces (e.g. ` test@abc.com `) → Enter valid password | Spaces should be trimmed & login successful | Positive |
| TC012 | Case sensitivity in email | Enter email in uppercase → Enter valid password | Login should work (email not case-sensitive) | Positive |
| TC013 | Case sensitivity in password | Enter valid email → Enter password with wrong case | Login should fail | Negative |
| TC014 | SQL injection attempt | Enter `test@abc.com' OR '1'='1` → Any password → Click **Login** | Login should fail | Negative |
| TC015 | Special characters in email | Enter special chars (except allowed `@ . _`) → Click **Login** | Show validation error | Negative |
| TC016 | Page load | Navigate to login URL | Login page loads in < 3 seconds | Positive |
| TC017 | Remember Me (if available) | Select **Remember Me** → Login → Logout → Relaunch app | Email should be pre-filled | Positive |
| TC018 | Browser back button after login | Login successfully → Click **Back** | User should stay on dashboard (not login page) | Positive |
| TC019 | Multiple failed attempts lockout | Enter wrong credentials 5 times | Account gets locked / Captcha appears | Negative |
| TC020 | Session timeout | Login → Stay idle for configured timeout → Perform action | User is logged out & redirected to login page | Positive |

---

## ✅ Coverage Summary  
- **Positive scenarios:** Valid login, UI elements, usability flows, session handling  
- **Negative scenarios:** Invalid inputs, empty fields, SQL injection, lockout mechanism  
- **UI checks:** Password masking, button state, validation messages  
