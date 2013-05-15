package asteroids.model.programs.statements;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;
import asteroids.model.programs.expressions.BooleanLiteral;
import asteroids.model.programs.expressions.Expression;

public class If extends Statement {
	public If(int line, int column, Expression condition, Statement then, Statement otherwise) {
		super(line, column);
		this.condition = condition;
		this.then = then;
		this.otherwise = otherwise;
	}
	
	private Expression condition;
	
	private Statement then;
	
	private Statement otherwise;

	public Expression getCondition() {
		return condition;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public Statement getThen() {
		return then;
	}

	public void setThen(Statement then) {
		this.then = then;
	}

	public Statement getOtherwise() {
		return otherwise;
	}

	public void setOtherwise(Statement otherwise) {
		this.otherwise = otherwise;
	}
	
	private boolean isCondition(Expression condition) {
		return ((BooleanLiteral) condition.getValue()).getBool();
	}

	@Override
	public void execute() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		if(isCondition(condition)) {
			then.execute();
		}
		else {
			otherwise.execute();
		}
	}
}
