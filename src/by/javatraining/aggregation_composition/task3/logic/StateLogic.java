package by.javatraining.aggregation_composition.task3.logic;

import by.javatraining.aggregation_composition.task3.entity.Region;
import by.javatraining.aggregation_composition.task3.entity.State;
import by.javatraining.aggregation_composition.task3.exception.InvalidValueException;
import by.javatraining.aggregation_composition.task3.exception.NameTakenException;
import by.javatraining.aggregation_composition.task3.view.RegionInfo;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class StateLogic {

	private final RegionLogic regionLogic;

	private State state;

	public StateLogic() {
		regionLogic = new RegionLogic();
	}

	public void setState(State state) {
		if (state == null) {
			this.state = new State();
		} else {
			this.state = state;
		}
	}
	
	public RegionLogic getRegionLogic() {
		return regionLogic;
	}

	public Region findRegionByName(String name) {
		for (Region region : state.getRegionList()) {
			if (region.getName().equals(name)) {
				return region;
			}
		}

		return null;
	}

	public void setMainRegion(String name) {
		state.setMainRegion(findRegionByName(name));
	}

	public void addRegion(String name, double areaSize) throws NameTakenException, InvalidValueException {
		if (findRegionByName(name) != null) {
			throw new NameTakenException("Область с этим именем уже есть.");
		} else {
			state.getRegionList().add(new Region(name, areaSize));
		}
	}

	public void addRegion(String name, double areaSize, boolean makeMain)
			throws NameTakenException, InvalidValueException {
		if (findRegionByName(name) != null) {
			throw new NameTakenException("Область с этим именем уже есть.");
		} else {
			Region newRegion = new Region(name, areaSize);
			state.getRegionList().add(newRegion);

			if (makeMain) {
				state.setMainRegion(newRegion);
			}
		}
	}

	public void removeRegion(String name) {
		Region forRemoval;

		forRemoval = findRegionByName(name);

		if (forRemoval != null) {
			regionLogic.setRegion(forRemoval);
			regionLogic.removeAllCitys();
			state.getRegionList().remove(forRemoval);

			if (forRemoval == state.getMainRegion()) {
				state.setMainRegion(null);
			}
		}
	}

	public void removeAllRegions() {
		for (Region region : state.getRegionList()) {
			regionLogic.setRegion(region);
			regionLogic.removeAllCitys();
		}

		state.setMainRegion(null);
		state.getRegionList().clear();
	}

	public String printStateCapital() {
		if (state.getMainRegion() == null) {
			return "Не задана столичная область.";
		} else {
			return "Столица: " + RegionInfo.getRegionCapitalName(state.getMainRegion().getRegionCapital());
		}
	}

	public String printRegionsCount() {
		return "Количество областей: " + state.getRegionList().size();
	}

	public String printRegionCapitals() {
		StringBuilder strRegionCapitals = new StringBuilder();

		strRegionCapitals.append("Список областных центров:\n");
		for (Region region : state.getRegionList()) {
			if (region != state.getMainRegion()) {
				strRegionCapitals.append("Область: " + region.getName() + ", Областной центр: "
						+ RegionInfo.getRegionCapitalName(region.getRegionCapital()));
			}
		}

		return strRegionCapitals.toString();
	}

	public String printStateAreaSize() {
		double stateSize = 0;

		for (Region region : state.getRegionList()) {
			stateSize = stateSize + region.getAreaSize();
		}

		return "Площадь государства" + state.getName() + ": " + stateSize + "км.кв.";
	}
}
