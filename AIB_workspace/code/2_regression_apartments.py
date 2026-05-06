import os
import pandas as pd
import xgboost as xgb
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_absolute_error, r2_score
import matplotlib.pyplot as plt
import seaborn as sns
import shutil

# Опит за намиране на Graphviz
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
BASE_DIR = os.path.dirname(SCRIPT_DIR)

def setup_graphviz():
    # 1. Проверка дали вече е в PATH
    if shutil.which("dot"):
        return True
    
    # 2. Проверка в локалната папка на проекта
    local_graphviz_bin = os.path.join(BASE_DIR, "graphviz", "Graphviz-14.1.5-win32", "bin")
    if os.path.exists(os.path.join(local_graphviz_bin, "dot.exe")):
        os.environ["PATH"] += os.pathsep + local_graphviz_bin
        return True
    
    # 3. Общи пътища в Windows
    common_paths = [
        r"C:\Program Files\Graphviz\bin",
        r"C:\Program Files (x86)\Graphviz\bin",
        os.path.expandvars(r"%LOCALAPPDATA%\bin")
    ]
    for path in common_paths:
        if os.path.exists(os.path.join(path, "dot.exe")):
            os.environ["PATH"] += os.pathsep + path
            return True
            
    return False

HAS_GRAPHVIZ = setup_graphviz()

# Пътища
DATA_PATH = os.path.join(BASE_DIR, 'data', 'apartments.csv')
REPORT_DIR = os.path.join(BASE_DIR, 'report')

# 1. Зареждане на данни
if not os.path.exists(DATA_PATH):
    print(f"Грешка: Липсва базата данни на път: {DATA_PATH}")
    exit()

df = pd.read_csv(DATA_PATH)
X = df.drop('Price_EUR', axis=1)
y = df['Price_EUR']

# 2. Разделяне на данни
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 3. Модел: Gradient Boosting (XGBoost Regressor)
regr = xgb.XGBRegressor(
    n_estimators=100,
    learning_rate=0.1,
    max_depth=4,
    random_state=42
)
regr.fit(X_train, y_train)

# 4. Предсказание и оценка
y_pred = regr.predict(X_test)
mae = mean_absolute_error(y_test, y_pred)
r2 = r2_score(y_test, y_pred)

print("--- РЕГРЕСИЯ: Цени на апартаменти (XGBoost - Gradient Boosting) ---")
print(f"Средна абсолютна грешка (MAE): {mae:.2f} EUR")
print(f"R2 Score: {r2:.4f}")

if not os.path.exists(REPORT_DIR):
    os.makedirs(REPORT_DIR)

# 5. Сравнение Реални срещу Предсказани цени
plt.figure(figsize=(10, 6))
plt.scatter(y_test, y_pred, alpha=0.5, color='orange')
plt.plot([y_test.min(), y_test.max()], [y_test.min(), y_test.max()], 'r--', lw=2)
plt.xlabel("Реални цени (EUR)")
plt.ylabel("Предсказани цени (EUR)")
plt.title("XGBoost Регресия: Реални срещу Предсказани цени")
plt.savefig(os.path.join(REPORT_DIR, "apartment_regression.png"))

# 6. Визуализация на случайно избрано дърво (напр. №42)
print("\nВизуализация на случайно избрано дърво от XGBoost (№42)...")
if HAS_GRAPHVIZ:
    try:
        plt.figure(figsize=(25, 15))
        xgb.plot_tree(regr, tree_idx=42, ax=plt.gca())
        plt.title("Визуализация на случайно дърво от XGBoost (Дърво №42)")
        plt.savefig(os.path.join(REPORT_DIR, "xgboost_random_tree.png"), bbox_inches='tight', dpi=300)
        print("Графиката на XGBoost дървото е запазена.")
    except Exception as e:
        print(f"Грешка при визуализация на XGBoost дърво: {e}")
else:
    print("Грешка: Не е намерен Graphviz (dot.exe). Визуализацията на XGBoost дървото е пропусната.")
    print("Моля, инсталирайте Graphviz от https://graphviz.org/download/ и добавете 'bin' папката към системния PATH.")
plt.show() # Премахнато за автоматично изпълнение без прозорци
