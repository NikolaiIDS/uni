import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report
import matplotlib.pyplot as plt
import seaborn as sns
import os

# Автоматично намиране на пътищата
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
BASE_DIR = os.path.dirname(SCRIPT_DIR)
DATA_PATH = os.path.join(BASE_DIR, 'data', 'employee_churn.csv')
REPORT_DIR = os.path.join(BASE_DIR, 'report')

# 1. Зареждане на данни
if not os.path.exists(DATA_PATH):
    print(f"Грешка: Липсва базата данни на път: {DATA_PATH}")
    exit()

df = pd.read_csv(DATA_PATH)
X = df.drop('Left', axis=1)
y = df['Left']

# 2. Разделяне на данни
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 3. Модел: Random Forest Classifier
# Използваме 100 дървета за стабилност
rf = RandomForestClassifier(n_estimators=100, random_state=42)
rf.fit(X_train, y_train)

# 4. Оценка
y_pred = rf.predict(X_test)
print("--- КЛАСИФИКАЦИЯ: Напускане на служители (Random Forest) ---")
print(f"Точност: {accuracy_score(y_test, y_pred) * 100:.2f}%")
print("\nОтчет за класификацията:\n", classification_report(y_test, y_pred))

if not os.path.exists(REPORT_DIR):
    os.makedirs(REPORT_DIR)

# 5. Визуализация на матрица на грешките
cm = confusion_matrix(y_test, y_pred)
plt.figure(figsize=(8, 6))
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['Stayed', 'Left'], yticklabels=['Stayed', 'Left'])
plt.title("Матрица на грешките: Напускане на служители (Random Forest)")
plt.xlabel("Предсказани")
plt.ylabel("Реални")
plt.savefig(os.path.join(REPORT_DIR, "employee_cm.png"))

# 6. Визуализация на ПОСЛЕДНОТО дърво от гората
print("\nВизуализация на ПОСЛЕДНОТО дърво от Random Forest (Дърво №99)...")
from sklearn.tree import plot_tree
plt.figure(figsize=(25, 15))
plot_tree(rf.estimators_[99], 
          feature_names=list(X.columns), 
          class_names=['Stayed', 'Left'], 
          filled=True, 
          rounded=True,
          fontsize=10)
plt.title("Визуализация на ПОСЛЕДНОТО индивидуално дърво от Random Forest (Дърво №99)")
plt.savefig(os.path.join(REPORT_DIR, "rf_last_tree.png"), bbox_inches='tight', dpi=300)

# 7. Важност на признаците
feature_imp = pd.Series(rf.feature_importances_, index=X.columns).sort_values(ascending=False)
plt.figure(figsize=(10, 6))
sns.barplot(x=feature_imp, y=feature_imp.index, hue=feature_imp.index, palette='plasma', legend=False)
plt.title("Важност на признаците (Employee Churn - Random Forest)")
plt.savefig(os.path.join(REPORT_DIR, "employee_features.png"))
plt.show() # Премахнато за автоматично изпълнение без прозорци
