package com.example.kbsc_cooperate.base


/*
@Composable
fun RooftopTabs(
    modifier: Modifier = Modifier,
    titles: List<String>,
    tabSelected: RooftopBottomBarItem,
    onTabSelected: (RooftopBottomBarItem) -> Unit
) {
    TabRow(
        selectedTabIndex = tabSelected.ordinal,
        modifier = modifier,
        contentColor = MaterialTheme.colors.onSurface,
        indicator = { tabPositions: List<TabPosition> ->
            Box {
                Modifier
                    .tabIndicatorOffset(tabPositions[tabSelected.ordinal])
                    .fillMaxSize()
                    .padding(horizontal = 4.dp)
                    .border(BorderStroke(2.dp, Color.White), RoundedCornerShape(16.dp))
            }
        },
        divider = { }
        ) {
        titles.forEachIndexed { index, title ->
            val selected = index == tabSelected.ordinal
            val textModifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)

            Tab(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .clip(RoundedCornerShape(16.dp)),
                selected = selected,
                onClick = {
                    onTabSelected(RooftopBottomBarItem.values()[index])
                }
            ) {
                Text(
                    modifier = textModifier,
                    text = title.uppercase(
                        ConfigurationCompat.getLocales(LocalConfiguration.current)[0]
                    )
                )
            }
        }
    }
}
*/
