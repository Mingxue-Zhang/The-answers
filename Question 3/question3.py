from sklearn.neural_network import MLPRegressor
import pandas as pd
# ref https://scikit-learn.org/stable/modules/generated/sklearn.neural_network.MLPRegressor.html
# Scikit-learn: Machine Learning in Python, Pedregosa et al., JMLR 12, pp. 2825-2830, 2011.
# Zhang Mingxue

train_data = pd.read_csv("train_data.txt", sep="\t")
train_truth = pd.read_csv("train_truth.txt", sep="\t")
test_data = pd.read_csv("test_data.txt", sep="\t")

train_data = train_data[['x1', 'x2', 'x3']]
#print(train_data)
y = train_truth['y']
predict = test_data[['x1', 'x2', 'x3']]

model = MLPRegressor(hidden_layer_sizes=(4, 4))
# train
model.fit(train_data, y)
y = model.predict(predict)

fo = open("output_question_3", "a")
fo.write("y\n")
for predict_restult in y:
    fo.write(str(predict_restult)+"\n")

fo.close()
