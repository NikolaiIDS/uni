import pandas as pd
import numpy as np
import os

# Автоматично намиране на базовата папка на проекта
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
DATA_DIR = os.path.join(BASE_DIR, 'data')

def generate_apartment_data(n_samples=500):
    np.random.seed(42)
    area = np.random.normal(70, 20, n_samples).clip(30, 200)
    rooms = (area / 30 + np.random.randint(0, 2, n_samples)).astype(int).clip(1, 5)
    floor = np.random.randint(1, 15, n_samples)
    dist_to_center = np.random.uniform(0.5, 15, n_samples)
    year_built = np.random.randint(1960, 2024, n_samples)
    
    price = (area * 1500) + (rooms * 5000) - (dist_to_center * 2000) + ((year_built - 1960) * 300) + np.random.normal(0, 10000, n_samples)
    
    df = pd.DataFrame({
        'Area_sqm': area,
        'Rooms': rooms,
        'Floor': floor,
        'Dist_to_Center_km': dist_to_center,
        'Year_Built': year_built,
        'Price_EUR': price
    })
    
    if not os.path.exists(DATA_DIR):
        os.makedirs(DATA_DIR)
    
    file_path = os.path.join(DATA_DIR, 'apartments.csv')
    df.to_csv(file_path, index=False)
    print(f"Генерирана база данни за апартаменти: {file_path}")

def generate_credit_data(n_samples=500):
    np.random.seed(42)
    income = np.random.normal(3000, 1000, n_samples).clip(1000, 10000)
    age = np.random.randint(18, 70, n_samples)
    emp_years = np.random.randint(0, 40, n_samples)
    loan_amount = np.random.normal(20000, 15000, n_samples).clip(1000, 200000)
    prev_defaults = np.random.choice([0, 1], n_samples, p=[0.85, 0.15])
    
    score = (income / 1000) * 2 + (emp_years * 0.5) - (prev_defaults * 10) - (loan_amount / 5000)
    approved = (score > 2).astype(int)
    
    df = pd.DataFrame({
        'Monthly_Income': income,
        'Age': age,
        'Years_of_Employment': emp_years,
        'Loan_Amount': loan_amount,
        'Previous_Defaults': prev_defaults,
        'Approved': approved
    })
    
    if not os.path.exists(DATA_DIR):
        os.makedirs(DATA_DIR)
    
    file_path = os.path.join(DATA_DIR, 'credit_approval.csv')
    df.to_csv(file_path, index=False)
    print(f"Генерирана база данни за кредити: {file_path}")

def generate_employee_data(n_samples=500):
    np.random.seed(42)
    satisfaction = np.random.uniform(0, 1, n_samples)
    evaluation = np.random.uniform(0, 1, n_samples)
    projects = np.random.randint(2, 7, n_samples)
    average_monthly_hours = np.random.randint(100, 310, n_samples)
    time_spend_company = np.random.randint(2, 10, n_samples)
    work_accident = np.random.choice([0, 1], n_samples, p=[0.8, 0.2])
    promotion_last_5years = np.random.choice([0, 1], n_samples, p=[0.95, 0.05])
    
    # Churn logic: Low satisfaction, high hours, and no promotion increase leave probability
    churn_prob = (1 - satisfaction) * 0.6 + (average_monthly_hours / 310) * 0.3 - promotion_last_5years * 0.5
    left = (churn_prob > 0.5).astype(int)
    
    df = pd.DataFrame({
        'Satisfaction_Level': satisfaction,
        'Last_Evaluation': evaluation,
        'Number_Projects': projects,
        'Monthly_Hours': average_monthly_hours,
        'Time_at_Company': time_spend_company,
        'Work_Accident': work_accident,
        'Promotion_Last_5Years': promotion_last_5years,
        'Left': left
    })
    
    if not os.path.exists(DATA_DIR):
        os.makedirs(DATA_DIR)
    
    file_path = os.path.join(DATA_DIR, 'employee_churn.csv')
    df.to_csv(file_path, index=False)
    print(f"Генерирана база данни за служители: {file_path}")

if __name__ == '__main__':
    generate_apartment_data()
    generate_credit_data()
    generate_employee_data()
