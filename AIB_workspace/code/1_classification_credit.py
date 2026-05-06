import pandas as pd
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix
import matplotlib.pyplot as plt
import seaborn as sns
import os

# Автоматично намиране на пътищата спрямо местоположението на скрипта
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
BASE_DIR = os.path.dirname(SCRIPT_DIR)
DATA_PATH = os.path.join(BASE_DIR, 'data', 'credit_approval.csv')
REPORT_DIR = os.path.join(BASE_DIR, 'report')

# 1. Зареждане на данни
if not os.path.exists(DATA_PATH):
    print(f"Грешка: Липсва базата данни на път: {DATA_PATH}")
    exit()

df = pd.read_csv(DATA_PATH)
X = df.drop('Approved', axis=1)
y = df['Approved']

# 2. Разделяне на данни
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 3. Модел: Класификатор
clf = DecisionTreeClassifier(max_depth=4, random_state=42)
clf.fit(X_train, y_train)

# 4. Оценка
y_pred = clf.predict(X_test)
print("--- КЛАСИФИКАЦИЯ: Одобрение на кредит ---")
print(f"Точност: {accuracy_score(y_test, y_pred) * 100:.2f}%")

if not os.path.exists(REPORT_DIR):
    os.makedirs(REPORT_DIR)

# 5. Визуализация на матрица на грешките
cm = confusion_matrix(y_test, y_pred)
plt.figure(figsize=(8, 6))
sns.heatmap(cm, annot=True, fmt='d', cmap='Greens', xticklabels=['Rejected', 'Approved'], yticklabels=['Rejected', 'Approved'])
plt.title("Матрица на грешките: Одобрение на кредит")
plt.xlabel("Предсказани")
plt.ylabel("Реални")
plt.savefig(os.path.join(REPORT_DIR, "credit_cm.png"))

# 6. Визуализация на дървото
plt.figure(figsize=(20, 10))
plot_tree(clf, feature_names=list(X.columns), class_names=['Rejected', 'Approved'], filled=True, rounded=True)
plt.title("Дърво на решенията: Одобрение на кредит (Класификация)")
plt.savefig(os.path.join(REPORT_DIR, "credit_tree.png"))
plt.show() # Премахнато за автоматично изпълнение без прозорци
